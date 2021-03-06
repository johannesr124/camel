/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.microprofile.metrics.message.history;

import org.apache.camel.NamedNode;
import org.apache.camel.Route;
import org.eclipse.microprofile.metrics.Tag;

import static org.apache.camel.component.microprofile.metrics.MicroProfileMetricsConstants.CAMEL_CONTEXT_TAG;
import static org.apache.camel.component.microprofile.metrics.MicroProfileMetricsConstants.DEFAULT_CAMEL_MESSAGE_HISTORY_METRIC_NAME;
import static org.apache.camel.component.microprofile.metrics.MicroProfileMetricsConstants.NODE_ID_TAG;
import static org.apache.camel.component.microprofile.metrics.MicroProfileMetricsConstants.ROUTE_ID_TAG;

public interface MicroProfileMetricsMessageHistoryNamingStrategy {

    MicroProfileMetricsMessageHistoryNamingStrategy DEFAULT = (route, node) -> DEFAULT_CAMEL_MESSAGE_HISTORY_METRIC_NAME;

    String getName(Route route, NamedNode node);

    default Tag[] getTags(Route route, NamedNode node) {
        return new Tag[] {
            new Tag(CAMEL_CONTEXT_TAG, route.getCamelContext().getName()),
            new Tag(ROUTE_ID_TAG, route.getId()),
            new Tag(NODE_ID_TAG, node.getId())
        };
    }
}
