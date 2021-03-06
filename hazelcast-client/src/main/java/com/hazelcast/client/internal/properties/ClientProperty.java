/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.internal.properties;

import com.hazelcast.internal.properties.HazelcastProperty;
import com.hazelcast.spi.annotation.PrivateApi;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Defines the name and default value for Hazelcast Client properties.
 */
@PrivateApi
public final class ClientProperty {

    /**
     * Client shuffles the given member list to prevent all clients to connect to the same node when
     * this property is set to false. When it is set to true, the client tries to connect to the nodes
     * in the given order.
     */
    public static final HazelcastProperty SHUFFLE_MEMBER_LIST
            = new HazelcastProperty("hazelcast.client.shuffle.member.list", true);

    /**
     * Client sends heartbeat messages to the members and this is the timeout for this sending operations.
     * If there is not any message passing between the client and member within the given time via this property
     * in milliseconds, the connection will be closed.
     */
    public static final HazelcastProperty HEARTBEAT_TIMEOUT
            = new HazelcastProperty("hazelcast.client.heartbeat.timeout", 60000, MILLISECONDS);

    /**
     * Time interval between the heartbeats sent by the client to the nodes.
     */
    public static final HazelcastProperty HEARTBEAT_INTERVAL
            = new HazelcastProperty("hazelcast.client.heartbeat.interval", 5000, MILLISECONDS);

    /**
     * Number of the threads to handle the incoming event packets.
     */
    public static final HazelcastProperty EVENT_THREAD_COUNT
            = new HazelcastProperty("hazelcast.client.event.thread.count", 5);

    /**
     * Capacity of the executor that handles the incoming event packets.
     */
    public static final HazelcastProperty EVENT_QUEUE_CAPACITY
            = new HazelcastProperty("hazelcast.client.event.queue.capacity", 1000000);

    /**
     * Time to give up on invocation when a member in the member list is not reachable.
     */
    public static final HazelcastProperty INVOCATION_TIMEOUT_SECONDS
            = new HazelcastProperty("hazelcast.client.invocation.timeout.seconds", 120, SECONDS);

    /**
     * The maximum number of concurrent invocations allowed.
     * <p/>
     * To prevent the system from overloading, user can apply a constraint on the number of concurrent invocations.
     * If the maximum number of concurrent invocations has been exceeded and a new invocation comes in,
     * then hazelcast will throw HazelcastOverloadException
     * <p/>
     * By default it is configured as Integer.MaxValue.
     */
    public static final HazelcastProperty MAX_CONCURRENT_INVOCATIONS
            = new HazelcastProperty("hazelcast.client.max.concurrent.invocations", Integer.MAX_VALUE);

    /**
     * <p>Enables the Discovery SPI lookup over the old native implementations. This property is temporary and will
     * eventually be removed when the experimental marker is removed.</p>
     * <p>Discovery SPI is <b>disabled</b> by default</p>
     */
    public static final HazelcastProperty DISCOVERY_SPI_ENABLED
            = new HazelcastProperty("hazelcast.discovery.enabled", false);

    private ClientProperty() {
    }
}
