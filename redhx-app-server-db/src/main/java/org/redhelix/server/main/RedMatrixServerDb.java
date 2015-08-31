/*
 * Copyright 2015 JBlade LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */



package org.redhelix.server.main;

import org.redhelix.core.chassis.RedHxChassisCollection;
import org.redhelix.core.service.root.RedHxTcpProtocolTypeEnum;
import org.redhelix.core.util.RedHxRedfishProtocolVersionEnum;

import java.net.URISyntaxException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <br><br>
 * Git SHA: $Id$
 *
 * @since RedHelix Version HELIX_VERSION_TAG // Do not change this line.
 * @author Hank Bruning
 *
 */
public class RedMatrixServerDb
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel",
                           "error");

        RedHxServerConnectionContext ctx = new RedHxServerConnectionContext();

        try
        {
            ctx.openConnection(RedHxTcpProtocolTypeEnum.HTTP,
                               "localhost",
                               9080,
                               "mockup1",
                               RedHxRedfishProtocolVersionEnum.VERSION_1);

            RedHxChassisCollection chassisCollection = ChassisCollectionReader.readChassisCollection(ctx);

            if (chassisCollection != null)
            {
                System.out.println("HFB5:  chassisCollection= " + chassisCollection);
            }
        }
        catch (URISyntaxException ex)
        {
            Logger.getLogger(RedMatrixServerDb.class.getName()).log(Level.SEVERE,
                    null,
                    ex);
        }
    }
}