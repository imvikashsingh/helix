package org.apache.helix;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * Exception thrown by Helix due to rebalance failures.
 */
public class HelixRebalanceException extends Exception {
  // TODO: Adding static description or other necessary fields into the enum instances for
  // TODO: supporting the rebalance monitor to understand the exception.
  public enum Type {
    INVALID_CLUSTER_STATUS,
    INVALID_REBALANCER_STATUS,
    FAILED_TO_CALCULATE,
    INVALID_INPUT,
    UNKNOWN_FAILURE
  }

  private final Type _type;

  public HelixRebalanceException(String message, Type type, Throwable cause) {
    super(String.format("%s Failure Type: %s", message, type.name()), cause);
    _type = type;
  }

  public HelixRebalanceException(String message, Type type) {
    super(String.format("%s Failure Type: %s", message, type.name()));
    _type = type;
  }

  public Type getFailureType() {
    return _type;
  }
}
