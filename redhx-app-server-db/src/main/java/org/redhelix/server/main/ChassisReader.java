/*
 * Copyright 2015 JBlade LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 *
 */



package org.redhelix.server.main;

import org.apache.olingo.client.api.communication.request.retrieve.ODataEntityRequest;
import org.apache.olingo.client.api.communication.response.ODataRetrieveResponse;
import org.apache.olingo.client.api.domain.ClientAnnotation;
import org.apache.olingo.client.api.domain.ClientComplexValue;
import org.apache.olingo.client.api.domain.ClientEntity;
import org.apache.olingo.client.api.domain.ClientProperty;

import org.redhelix.core.chassis.id.RedHxChassisManufacturerName;
import org.redhelix.core.chassis.id.RedHxChassisSerialNumber;
import org.redhelix.core.chassis.RedHxChassis;
import org.redhelix.core.chassis.RedHxChassisBuilder;
import org.redhelix.core.service.root.RedHxServiceRootIdEum;
import org.redhelix.core.util.RedHxHttpResponseException;

import java.net.HttpURLConnection;
import java.net.URISyntaxException;

import java.util.Iterator;

/**
 *
 * <br><br>
 * Git SHA: $Id$
 *
 * @since RedHelix Version HELIX_VERSION_TAG // Do not change this line.
 * @author Hank Bruning
 *
 */
final class ChassisReader
{
    private ChassisReader( ) {}

    static RedHxChassis readChassis( RedHxServerConnectionContext ctx,
                                     String                       chassisLink )
            throws RedHxHttpResponseException,
                   URISyntaxException
    {
        final ODataEntityRequest<ClientEntity>    req      = ctx.getEntityRequest(chassisLink);
        final ODataRetrieveResponse<ClientEntity> response = req.execute();
        final RedHxChassis                        chassis;

        System.out.println("HFB5: HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");

        if (response.getStatusCode() == HttpURLConnection.HTTP_OK)
        {
            ClientEntity                 entity           = response.getBody();
            RedHxChassisManufacturerName manufacturerName = null;
            RedHxChassisSerialNumber     serialNumber     = null;

            for (ClientProperty prop : entity.getProperties())
            {
                if (prop.hasComplexValue())
                {
                    final ClientComplexValue val = prop.getComplexValue();

                    if (!val.getAnnotations().isEmpty())
                    {
                        for (int i = 0; i < val.getAnnotations().size(); ++i)
                        {
                            ClientAnnotation anno = val.getAnnotations().get(i);

                            System.out.println("HFB5: anno-" + i + "=" + anno.getTerm() + ", " + anno.getValue());
                        }
                    }
                    else if (val.isPrimitive())
                    {
                        System.out.println("HFB5: primitive " + val.asPrimitive());
                    }
                    else if (val.isCollection())
                    {
                        System.out.println("HFB5: collection " + val.asCollection());
                    }
                    else if (val.isComplex())
                    {
                        final ClientComplexValue cplx = val.asComplex();
                        Iterator<ClientProperty> iter = cplx.iterator();

                        while (iter.hasNext())
                        {
                            ClientProperty prop2 = iter.next();

                            if (prop2.hasPrimitiveValue())
                            {
                                System.out.println("HFB5:     prop2 primitive=" + prop2.getName() + ", " + prop2.getValue());
                            }
                            else if (prop2.hasComplexValue())
                            {
                                final ClientComplexValue cplx2 = prop2.getComplexValue();

                                if (!cplx2.getAnnotations().isEmpty())
                                {
                                    for (int i = 0; i < cplx2.getAnnotations().size(); ++i)
                                    {
                                        ClientAnnotation anno = cplx2.getAnnotations().get(i);

                                        System.out.println("HFB5:     prop2 cplx2=" + anno.getTerm() + ", " + anno.getValue());
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("HFB5:     prop2 Unknown=" + prop2.getName() + ", " + prop2.getAnnotations());
                            }
                        }

                        // System.out.println("HFB5: complex " + cplx.get(chassisLink));
                    }
                    else if (!val.getAnnotations().isEmpty())
                    {
                        System.out.println("HFB5:       annontaions2=" + val.getAnnotations());
                    }
                }
                else if (prop.getName() != null)
                {
                    System.out.println("HFB5: property name " + prop.getName() + ", " + prop.getValue());
                }
                else
                {
                    System.out.println("HFB5: unknown property=" + prop);

                    if (prop.hasCollectionValue())
                    {
                        System.out.println("HFB5: collection val=" + prop.getCollectionValue());
                    }
                }
            }

            RedHxChassisBuilder builder = new RedHxChassisBuilder(manufacturerName,
                    serialNumber);

            chassis = builder.getInstance();
        }
        else
        {
            throw new RedHxHttpResponseException(RedHxServiceRootIdEum.CHASSIS,
                    response.getStatusCode(),
                    "Can not read Chassis Collection.");
        }

        return chassis;
    }
}
