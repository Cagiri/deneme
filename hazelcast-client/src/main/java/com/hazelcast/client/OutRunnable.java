/*
 * Copyright (c) 2007-2008, Hazel Ltd. All Rights Reserved.
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
 *
 */

package com.hazelcast.client;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OutRunnable extends NetworkRunnable implements Runnable{
	PacketWriter writer = new PacketWriter();
	BlockingQueue<Call> queue = new LinkedBlockingQueue<Call>();
	public void run() {
		while(true){
			 try {
				Call c = queue.take();
				writer.write(c.getRequest());
				callMap.put(c.getId(), c);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void enQueue(Call packet){
		try {
			queue.put(packet);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setPacketWriter(PacketWriter writer) {
		this.writer = writer;
		
	}

}
