/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zookeeper.server.util;

public class ZxidUtils {
	static public long getEpochFromZxid(long zxid) {
		return zxid >> 32L;
	}
	static public long getCounterFromZxid(long zxid) {
		return zxid & 0xffffffffL;
	}
	static public long makeZxid(long epoch, long counter) {

		/**
		 * 111 << 3
		 * 111000
		 * |
		 * 000000
		 *
		 * 111000
		 * 所以 该方法得到的 是前32位（即当前leader这一届的固定值）。后32为从0开始
		 */
		return (epoch << 32L) | (counter & 0xffffffffL);
	}
	static public String zxidToString(long zxid) {
		return Long.toHexString(zxid);
	}


}
