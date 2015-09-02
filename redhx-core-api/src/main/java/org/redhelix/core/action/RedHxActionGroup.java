/*
 * Copyright 2015 JBlade LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License
 */



package org.redhelix.core.action;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * get the set of actions.
 *
 * @since RedHelix Version 0.1
 * @author Hank Bruning
 *
 */
public final class RedHxActionGroup
{
    private final Set<RedHxActionProperties> actionSet;

    public RedHxActionGroup( final Set<RedHxActionProperties> actionSet )
    {
        this.actionSet = Collections.unmodifiableSet(actionSet);
    }

    private RedHxActionGroup( )
    {
        this.actionSet = null;
    }

    @Override
    public boolean equals( Object obj )
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

        final RedHxActionGroup other = (RedHxActionGroup) obj;

        if (!Objects.equals(this.actionSet, other.actionSet))
        {
            return false;
        }

        return true;
    }

    public Set<RedHxActionProperties> getActionSet( )
    {
        return actionSet;
    }

    @Override
    public int hashCode( )
    {
        int hash = 3;

        hash = 73 * hash + Objects.hashCode(this.actionSet);

        return hash;
    }

    @Override
    public String toString( )
    {
        StringBuilder sb = new StringBuilder();

        sb.append("{ ");
        sb.append(actionSet);
        sb.append(" }");

        return sb.toString();
    }
}