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

package org.redhelix.core.sensor;

/**
 * 
 * Git SHA: $Id$
 * 
 * @since RedHelix Version HELIX_VERSION_TAG // Do not change this line.
 * @author Hank Bruning
 *
 */
public class RedHxSensorNumber
{

    private final int sensorNumber;

    private RedHxSensorNumber()
    {
        this.sensorNumber = 0;
    }

    public RedHxSensorNumber(final int sensorNumber)
    {
        this.sensorNumber = sensorNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final RedHxSensorNumber other = (RedHxSensorNumber) obj;
        if (sensorNumber != other.sensorNumber)
        {
            return false;
        }
        return true;
    }

    public int getSensorNumber()
    {
        return sensorNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + sensorNumber;
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("sensorNumber=, " + sensorNumber);
        sb.append(", ");
        sb.append("]");
        return sb.toString();
    }

}
