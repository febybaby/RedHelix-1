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
 *
 */
package org.redhelix.server.lib.filter.hw;

import org.redhelix.server.lib.filter.util.RedHxAbstractFilter;

/**
 *
 * filter hardware by physical attributes.
 * <p>
 * The filter contains these parameters:
 * </p>
 * <ul>
 * <li>siteName</li>
 * <li>roomName</li>
 * <li>rackName</li>
 * <li>redfishHardwareType</li>
 * <li>manufacturerName</li>
 * <li>redfishSchemaVersion</li>
 * <li>poweredBy</li>
 * <li>cooledBy</li>
 * <li>poweredOnState</li>
 * <li>operatingState</li>
 * </ul>
 *
 * @since RedHelix Version 0.2
 * @author Hank Bruning
 *
 */
public final class RedHxFilterHardware extends RedHxAbstractFilter {
}
