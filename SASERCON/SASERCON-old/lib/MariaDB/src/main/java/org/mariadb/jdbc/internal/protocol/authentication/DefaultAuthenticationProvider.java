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


package org.mariadb.jdbc.internal.protocol.authentication;

import java.sql.SQLException;

import org.mariadb.jdbc.internal.com.send.authentication.AuthenticationPlugin;
import org.mariadb.jdbc.internal.com.send.authentication.ClearPasswordPlugin;
import org.mariadb.jdbc.internal.com.send.authentication.Ed25519PasswordPlugin;
import org.mariadb.jdbc.internal.com.send.authentication.NativePasswordPlugin;
import org.mariadb.jdbc.internal.com.send.authentication.OldPasswordPlugin;
import org.mariadb.jdbc.internal.com.send.authentication.SendGssApiAuthPacket;
import org.mariadb.jdbc.internal.com.send.authentication.SendPamAuthPacket;
import org.mariadb.jdbc.internal.util.Options;

public class DefaultAuthenticationProvider {

  public static final String MYSQL_NATIVE_PASSWORD = "mysql_native_password";
  public static final String MYSQL_OLD_PASSWORD = "mysql_old_password";
  public static final String MYSQL_CLEAR_PASSWORD = "mysql_clear_password";
  public static final String MYSQL_ED25519_PASSWORD = "client_ed25519";
  private static final String GSSAPI_CLIENT = "auth_gssapi_client";
  private static final String DIALOG = "dialog";

  /**
   * Process AuthenticationSwitch.
   *
   * @param plugin                    plugin name
   * @param password                  password
   * @param authData                  auth data
   * @param options                   connection string options
   * @return authentication response according to parameters
   * @throws SQLException if error occur.
   */
  public static AuthenticationPlugin processAuthPlugin(String plugin,
                                                       String password,
                                                       byte[] authData,
                                                       Options options)
      throws SQLException {
    switch (plugin) {
      case MYSQL_NATIVE_PASSWORD:
        return new NativePasswordPlugin(password, authData, options.passwordCharacterEncoding);
      case MYSQL_OLD_PASSWORD:
        return new OldPasswordPlugin(password, authData);
      case MYSQL_CLEAR_PASSWORD:
        return new ClearPasswordPlugin(password, options.passwordCharacterEncoding);
      case DIALOG:
        return new SendPamAuthPacket(password, authData, options.passwordCharacterEncoding);
      case GSSAPI_CLIENT:
        return new SendGssApiAuthPacket(authData, options.servicePrincipalName);
      case MYSQL_ED25519_PASSWORD:
        return new Ed25519PasswordPlugin(password, authData, options.passwordCharacterEncoding);

      default:
        throw new SQLException(
            "Client does not support authentication protocol requested by server. "
                + "Consider upgrading MariaDB client. plugin was = " + plugin, "08004", 1251);
    }
  }

}
