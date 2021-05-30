/*
 *
 * MariaDB Client for Java
 *
 * Copyright (c) 2012-2014 Monty Program Ab.
 * Copyright (c) 2015-2017 MariaDB Ab.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to Monty Program Ab info@montyprogram.com.
 *
 * This particular MariaDB Client for Java file is work
 * derived from a Drizzle-JDBC. Drizzle-JDBC file which is covered by subject to
 * the following copyright and notice provisions:
 *
 * Copyright (c) 2009-2011, Marcus Eriksson
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of the driver nor the names of its contributors may not be
 * used to endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS  AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 *
 */

package org.mariadb.jdbc.internal.util;

import java.lang.reflect.Field;
import java.sql.DriverManager;

@SuppressWarnings("ConstantConditions")
public class Options implements Cloneable {

  public static final int MIN_VALUE__MAX_IDLE_TIME = 60;

  //standard options
  public String user;
  public String password;

  //divers
  public boolean trustServerCertificate;
  public String serverSslCert;
  public String trustStore;
  public String trustStoreType;
  public String keyStoreType;
  public String trustStorePassword;
  public String keyStore;
  public String keyStorePassword;
  public String keyPassword;
  public String enabledSslProtocolSuites;
  public boolean useFractionalSeconds = true;
  public boolean pinGlobalTxToPhysicalConnection;
  public String socketFactory;
  public int connectTimeout =
      DriverManager.getLoginTimeout() > 0 ? DriverManager.getLoginTimeout() * 1000 : 30_000;
  public String pipe;
  public String localSocket;
  public String sharedMemory;
  public boolean tcpNoDelay = true;
  public boolean tcpKeepAlive = true;
  public Integer tcpRcvBuf;
  public Integer tcpSndBuf;
  public boolean tcpAbortiveClose;
  public String localSocketAddress;
  public Integer socketTimeout;
  public boolean allowMultiQueries;
  public boolean rewriteBatchedStatements;
  public boolean useCompression;
  public boolean interactiveClient;
  public String passwordCharacterEncoding;

  public boolean useSsl;
  public String enabledSslCipherSuites;
  public String sessionVariables;
  public boolean tinyInt1isBit = true;
  public boolean yearIsDateType = true;
  public boolean createDatabaseIfNotExist;
  public String serverTimezone;
  public boolean nullCatalogMeansCurrent = true;
  public boolean dumpQueriesOnException;
  public boolean useOldAliasMetadataBehavior;
  public boolean useMysqlMetadata;
  public boolean allowLocalInfile = true;
  public boolean cachePrepStmts = true;
  public int prepStmtCacheSize = 250;
  public int prepStmtCacheSqlLimit = 2048;
  public boolean useLegacyDatetimeCode = true;
  public boolean useAffectedRows;
  public boolean maximizeMysqlCompatibility;
  public boolean useServerPrepStmts;
  public boolean continueBatchOnError = true;
  public boolean jdbcCompliantTruncation = true;
  public boolean cacheCallableStmts = true;
  public int callableStmtCacheSize = 150;
  public String connectionAttributes;
  public Boolean useBatchMultiSend;
  public int useBatchMultiSendNumber = 100;
  public Boolean usePipelineAuth;
  public boolean enablePacketDebug;
  public boolean useBulkStmts;
  public boolean disableSslHostnameVerification;
  public boolean autocommit = true;
  public boolean includeInnodbStatusInDeadlockExceptions;
  public boolean includeThreadDumpInDeadlockExceptions;
  public String servicePrincipalName;

  //logging options
  public boolean log;
  public boolean profileSql;
  public int maxQuerySizeToLog = 1024;
  public Long slowQueryThresholdNanos;

  //HA options
  public boolean assureReadOnly;
  public boolean autoReconnect;
  public boolean failOnReadOnly;
  public int retriesAllDown = 120;
  public int validConnectionTimeout;
  public int loadBalanceBlacklistTimeout = 50;
  public int failoverLoopRetries = 120;
  public boolean allowMasterDownConnection;
  public String galeraAllowedState;

  //Pool options
  public boolean pool;
  public String poolName;
  public int maxPoolSize = 8;
  public Integer minPoolSize;
  public int maxIdleTime = 600;
  public boolean staticGlobal;
  public boolean registerJmxPool = true;
  public int poolValidMinDelay = 1000;
  public boolean useResetConnection;
  public boolean useReadAheadInput = true;

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    String newLine = System.getProperty("line.separator");
    result.append(this.getClass().getName());
    result.append(" Options {");
    result.append(newLine);

    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      result.append("  ");
      try {
        result.append(field.getName());
        result.append(": ");
        //requires access to private field:
        result.append(field.get(this));
      } catch (IllegalAccessException ex) {
        //ignore error
      }
      result.append(newLine);
    }
    result.append("}");
    return result.toString();
  }

  @SuppressWarnings("SimplifiableIfStatement")
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Options opt = (Options) obj;

    if (trustServerCertificate != opt.trustServerCertificate) {
      return false;
    }
    if (useFractionalSeconds != opt.useFractionalSeconds) {
      return false;
    }
    if (pinGlobalTxToPhysicalConnection != opt.pinGlobalTxToPhysicalConnection) {
      return false;
    }
    if (tcpNoDelay != opt.tcpNoDelay) {
      return false;
    }
    if (tcpKeepAlive != opt.tcpKeepAlive) {
      return false;
    }
    if (tcpAbortiveClose != opt.tcpAbortiveClose) {
      return false;
    }
    if (allowMultiQueries != opt.allowMultiQueries) {
      return false;
    }
    if (rewriteBatchedStatements != opt.rewriteBatchedStatements) {
      return false;
    }
    if (useCompression != opt.useCompression) {
      return false;
    }
    if (interactiveClient != opt.interactiveClient) {
      return false;
    }
    if (useSsl != opt.useSsl) {
      return false;
    }
    if (tinyInt1isBit != opt.tinyInt1isBit) {
      return false;
    }
    if (yearIsDateType != opt.yearIsDateType) {
      return false;
    }
    if (createDatabaseIfNotExist != opt.createDatabaseIfNotExist) {
      return false;
    }
    if (nullCatalogMeansCurrent != opt.nullCatalogMeansCurrent) {
      return false;
    }
    if (dumpQueriesOnException != opt.dumpQueriesOnException) {
      return false;
    }
    if (useOldAliasMetadataBehavior != opt.useOldAliasMetadataBehavior) {
      return false;
    }
    if (allowLocalInfile != opt.allowLocalInfile) {
      return false;
    }
    if (cachePrepStmts != opt.cachePrepStmts) {
      return false;
    }
    if (useLegacyDatetimeCode != opt.useLegacyDatetimeCode) {
      return false;
    }
    if (useAffectedRows != opt.useAffectedRows) {
      return false;
    }
    if (maximizeMysqlCompatibility != opt.maximizeMysqlCompatibility) {
      return false;
    }
    if (useServerPrepStmts != opt.useServerPrepStmts) {
      return false;
    }
    if (continueBatchOnError != opt.continueBatchOnError) {
      return false;
    }
    if (jdbcCompliantTruncation != opt.jdbcCompliantTruncation) {
      return false;
    }
    if (cacheCallableStmts != opt.cacheCallableStmts) {
      return false;
    }
    if (useBatchMultiSendNumber != opt.useBatchMultiSendNumber) {
      return false;
    }
    if (enablePacketDebug != opt.enablePacketDebug) {
      return false;
    }
    if (includeInnodbStatusInDeadlockExceptions != opt.includeInnodbStatusInDeadlockExceptions) {
      return false;
    }
    if (includeThreadDumpInDeadlockExceptions != opt.includeThreadDumpInDeadlockExceptions) {
      return false;
    }
    if (useBulkStmts != opt.useBulkStmts) {
      return false;
    }
    if (disableSslHostnameVerification != opt.disableSslHostnameVerification) {
      return false;
    }
    if (log != opt.log) {
      return false;
    }
    if (profileSql != opt.profileSql) {
      return false;
    }
    if (assureReadOnly != opt.assureReadOnly) {
      return false;
    }
    if (autoReconnect != opt.autoReconnect) {
      return false;
    }
    if (failOnReadOnly != opt.failOnReadOnly) {
      return false;
    }
    if (allowMasterDownConnection != opt.allowMasterDownConnection) {
      return false;
    }
    if (retriesAllDown != opt.retriesAllDown) {
      return false;
    }
    if (validConnectionTimeout != opt.validConnectionTimeout) {
      return false;
    }
    if (loadBalanceBlacklistTimeout != opt.loadBalanceBlacklistTimeout) {
      return false;
    }
    if (failoverLoopRetries != opt.failoverLoopRetries) {
      return false;
    }
    if (pool != opt.pool) {
      return false;
    }
    if (staticGlobal != opt.staticGlobal) {
      return false;
    }
    if (registerJmxPool != opt.registerJmxPool) {
      return false;
    }
    if (useResetConnection != opt.useResetConnection) {
      return false;
    }
    if (useReadAheadInput != opt.useReadAheadInput) {
      return false;
    }
    if (maxPoolSize != opt.maxPoolSize) {
      return false;
    }
    if (maxIdleTime != opt.maxIdleTime) {
      return false;
    }
    if (poolValidMinDelay != opt.poolValidMinDelay) {
      return false;
    }
    if (user != null ? !user.equals(opt.user) : opt.user != null) {
      return false;
    }
    if (password != null ? !password.equals(opt.password) : opt.password != null) {
      return false;
    }
    if (serverSslCert != null ? !serverSslCert.equals(opt.serverSslCert)
        : opt.serverSslCert != null) {
      return false;
    }
    if (trustStore != null ? !trustStore.equals(opt.trustStore) : opt.trustStore != null) {
      return false;
    }
    if (trustStorePassword != null ? !trustStorePassword.equals(opt.trustStorePassword)
        : opt.trustStorePassword != null) {
      return false;
    }
    if (keyStore != null ? !keyStore.equals(opt.keyStore) : opt.keyStore != null) {
      return false;
    }
    if (keyStorePassword != null ? !keyStorePassword.equals(opt.keyStorePassword)
        : opt.keyStorePassword != null) {
      return false;
    }
    if (keyPassword != null ? !keyPassword.equals(opt.keyPassword) : opt.keyPassword != null) {
      return false;
    }
    if (enabledSslProtocolSuites != null) {
      if (!enabledSslProtocolSuites.equals(opt.enabledSslProtocolSuites)) {
        return false;
      }
    } else if (opt.enabledSslProtocolSuites != null) {
      return false;
    }
    if (socketFactory != null ? !socketFactory.equals(opt.socketFactory)
        : opt.socketFactory != null) {
      return false;
    }
    if (connectTimeout != opt.connectTimeout) {
      return false;
    }
    if (pipe != null ? !pipe.equals(opt.pipe) : opt.pipe != null) {
      return false;
    }
    if (localSocket != null ? !localSocket.equals(opt.localSocket) : opt.localSocket != null) {
      return false;
    }
    if (sharedMemory != null ? !sharedMemory.equals(opt.sharedMemory) : opt.sharedMemory != null) {
      return false;
    }
    if (tcpRcvBuf != null ? !tcpRcvBuf.equals(opt.tcpRcvBuf) : opt.tcpRcvBuf != null) {
      return false;
    }
    if (tcpSndBuf != null ? !tcpSndBuf.equals(opt.tcpSndBuf) : opt.tcpSndBuf != null) {
      return false;
    }
    if (localSocketAddress != null ? !localSocketAddress.equals(opt.localSocketAddress)
        : opt.localSocketAddress != null) {
      return false;
    }
    if (socketTimeout != null ? !socketTimeout.equals(opt.socketTimeout)
        : opt.socketTimeout != null) {
      return false;
    }
    if (passwordCharacterEncoding != null) {
      if (!passwordCharacterEncoding.equals(opt.passwordCharacterEncoding)) {
        return false;
      }
    } else if (opt.passwordCharacterEncoding != null) {
      return false;
    }

    if (enabledSslCipherSuites != null ? !enabledSslCipherSuites.equals(opt.enabledSslCipherSuites)
        : opt.enabledSslCipherSuites != null) {
      return false;
    }
    if (sessionVariables != null ? !sessionVariables.equals(opt.sessionVariables)
        : opt.sessionVariables != null) {
      return false;
    }
    if (serverTimezone != null ? !serverTimezone.equals(opt.serverTimezone)
        : opt.serverTimezone != null) {
      return false;
    }
    if (prepStmtCacheSize != opt.prepStmtCacheSize) {
      return false;
    }
    if (prepStmtCacheSqlLimit != opt.prepStmtCacheSqlLimit) {
      return false;
    }
    if (callableStmtCacheSize != opt.callableStmtCacheSize) {
      return false;
    }
    if (connectionAttributes != null ? !connectionAttributes.equals(opt.connectionAttributes)
        : opt.connectionAttributes != null) {
      return false;
    }
    if (useBatchMultiSend != null ? !useBatchMultiSend.equals(opt.useBatchMultiSend)
        : opt.useBatchMultiSend != null) {
      return false;
    }
    if (usePipelineAuth != null ? !usePipelineAuth.equals(opt.usePipelineAuth)
        : opt.usePipelineAuth != null) {
      return false;
    }
    if (maxQuerySizeToLog != opt.maxQuerySizeToLog) {
      return false;
    }
    if (slowQueryThresholdNanos != null ? !slowQueryThresholdNanos
        .equals(opt.slowQueryThresholdNanos) : opt.slowQueryThresholdNanos != null) {
      return false;
    }
    if (autocommit != opt.autocommit) {
      return false;
    }
    if (poolName != null ? !poolName.equals(opt.poolName) : opt.poolName != null) {
      return false;
    }
    if (galeraAllowedState != null ? !galeraAllowedState.equals(opt.galeraAllowedState)
        : opt.galeraAllowedState != null) {
      return false;
    }
    return minPoolSize != null ? minPoolSize.equals(opt.minPoolSize) : opt.minPoolSize == null;
  }

  @SuppressWarnings("SimplifiableIfStatement")
  @Override
  public int hashCode() {
    int result = user != null ? user.hashCode() : 0;
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (trustServerCertificate ? 1 : 0);
    result = 31 * result + (serverSslCert != null ? serverSslCert.hashCode() : 0);
    result = 31 * result + (trustStore != null ? trustStore.hashCode() : 0);
    result = 31 * result + (trustStorePassword != null ? trustStorePassword.hashCode() : 0);
    result = 31 * result + (keyStore != null ? keyStore.hashCode() : 0);
    result = 31 * result + (keyStorePassword != null ? keyStorePassword.hashCode() : 0);
    result = 31 * result + (keyPassword != null ? keyPassword.hashCode() : 0);
    result =
        31 * result + (enabledSslProtocolSuites != null ? enabledSslProtocolSuites.hashCode() : 0);
    result = 31 * result + (useFractionalSeconds ? 1 : 0);
    result = 31 * result + (pinGlobalTxToPhysicalConnection ? 1 : 0);
    result = 31 * result + (socketFactory != null ? socketFactory.hashCode() : 0);
    result = 31 * result + connectTimeout;
    result = 31 * result + (pipe != null ? pipe.hashCode() : 0);
    result = 31 * result + (localSocket != null ? localSocket.hashCode() : 0);
    result = 31 * result + (sharedMemory != null ? sharedMemory.hashCode() : 0);
    result = 31 * result + (tcpNoDelay ? 1 : 0);
    result = 31 * result + (tcpKeepAlive ? 1 : 0);
    result = 31 * result + (tcpRcvBuf != null ? tcpRcvBuf.hashCode() : 0);
    result = 31 * result + (tcpSndBuf != null ? tcpSndBuf.hashCode() : 0);
    result = 31 * result + (tcpAbortiveClose ? 1 : 0);
    result = 31 * result + (localSocketAddress != null ? localSocketAddress.hashCode() : 0);
    result = 31 * result + (socketTimeout != null ? socketTimeout.hashCode() : 0);
    result = 31 * result + (allowMultiQueries ? 1 : 0);
    result = 31 * result + (rewriteBatchedStatements ? 1 : 0);
    result = 31 * result + (useCompression ? 1 : 0);
    result = 31 * result + (interactiveClient ? 1 : 0);
    result = 31 * result + (passwordCharacterEncoding != null ? passwordCharacterEncoding.hashCode()
        : 0);
    result = 31 * result + (useSsl ? 1 : 0);
    result = 31 * result + (enabledSslCipherSuites != null ? enabledSslCipherSuites.hashCode() : 0);
    result = 31 * result + (sessionVariables != null ? sessionVariables.hashCode() : 0);
    result = 31 * result + (tinyInt1isBit ? 1 : 0);
    result = 31 * result + (yearIsDateType ? 1 : 0);
    result = 31 * result + (createDatabaseIfNotExist ? 1 : 0);
    result = 31 * result + (serverTimezone != null ? serverTimezone.hashCode() : 0);
    result = 31 * result + (nullCatalogMeansCurrent ? 1 : 0);
    result = 31 * result + (dumpQueriesOnException ? 1 : 0);
    result = 31 * result + (useOldAliasMetadataBehavior ? 1 : 0);
    result = 31 * result + (allowLocalInfile ? 1 : 0);
    result = 31 * result + (cachePrepStmts ? 1 : 0);
    result = 31 * result + prepStmtCacheSize;
    result = 31 * result + prepStmtCacheSqlLimit;
    result = 31 * result + (useLegacyDatetimeCode ? 1 : 0);
    result = 31 * result + (useAffectedRows ? 1 : 0);
    result = 31 * result + (maximizeMysqlCompatibility ? 1 : 0);
    result = 31 * result + (useServerPrepStmts ? 1 : 0);
    result = 31 * result + (continueBatchOnError ? 1 : 0);
    result = 31 * result + (jdbcCompliantTruncation ? 1 : 0);
    result = 31 * result + (cacheCallableStmts ? 1 : 0);
    result = 31 * result + callableStmtCacheSize;
    result = 31 * result + (connectionAttributes != null ? connectionAttributes.hashCode() : 0);
    result = 31 * result + (useBatchMultiSend != null ? useBatchMultiSend.hashCode() : 0);
    result = 31 * result + useBatchMultiSendNumber;
    result = 31 * result + (usePipelineAuth != null ? usePipelineAuth.hashCode() : 0);
    result = 31 * result + (enablePacketDebug ? 1 : 0);
    result = 31 * result + (includeInnodbStatusInDeadlockExceptions ? 1 : 0);
    result = 31 * result + (includeThreadDumpInDeadlockExceptions ? 1 : 0);
    result = 31 * result + (useBulkStmts ? 1 : 0);
    result = 31 * result + (disableSslHostnameVerification ? 1 : 0);
    result = 31 * result + (log ? 1 : 0);
    result = 31 * result + (profileSql ? 1 : 0);
    result = 31 * result + maxQuerySizeToLog;
    result =
        31 * result + (slowQueryThresholdNanos != null ? slowQueryThresholdNanos.hashCode() : 0);
    result = 31 * result + (assureReadOnly ? 1 : 0);
    result = 31 * result + (autoReconnect ? 1 : 0);
    result = 31 * result + (failOnReadOnly ? 1 : 0);
    result = 31 * result + (allowMasterDownConnection ? 1 : 0);
    result = 31 * result + retriesAllDown;
    result = 31 * result + validConnectionTimeout;
    result = 31 * result + loadBalanceBlacklistTimeout;
    result = 31 * result + failoverLoopRetries;
    result = 31 * result + (pool ? 1 : 0);
    result = 31 * result + (registerJmxPool ? 1 : 0);
    result = 31 * result + (useResetConnection ? 1 : 0);
    result = 31 * result + (useReadAheadInput ? 1 : 0);
    result = 31 * result + (staticGlobal ? 1 : 0);
    result = 31 * result + (poolName != null ? poolName.hashCode() : 0);
    result = 31 * result + (galeraAllowedState != null ? galeraAllowedState.hashCode() : 0);
    result = 31 * result + maxPoolSize;
    result = 31 * result + (minPoolSize != null ? minPoolSize.hashCode() : 0);
    result = 31 * result + maxIdleTime;
    result = 31 * result + poolValidMinDelay;
    result = 31 * result + (autocommit ? 1 : 0);

    return result;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
