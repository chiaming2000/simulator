/**
 * Copyright (C) 2014 Seagate Technology.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.seagate.kinetic.admin.impl;

import java.util.List;

import kinetic.admin.Configuration;
import kinetic.admin.Interface;

public class DefaultConfiguration implements Configuration {

    // name of the vendor. Should be "Seagate"
    private String vendor;

    // name of the device. Have no clue what this should be...
    private String model;

    // Device Serial number from the underlying drive
    private String serialNumber;

    // device WWN
    private String wwn = null;

    // This is the version of the software on the drive in dot notation
    // if this is not set or ends with "x" this is test code.
    private String version;

    // This is the date/time string of when the source was compiled
    private String compilationDate;

    // This is the git hash of the source tree so that the exact code can be
    // determined.
    private String sourceHash;

    // This is the protocol version of the software on the drive in dot notation
    private String protocolVersion;

    // This is the date/time string of when the protocol source was compiled
    private String protocolCompilationDate;

    // This is the git hash of the protocol source tree so that the exact code
    // can be determined.
    private String protocolSourceHash;

    // the interfaces for this device. one per interface.
    private List<Interface> interfaces;

    // these are the port numbers for the software
    private int port;

    private int tlsPort;

    @Override
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getCompilationDate() {
        return compilationDate;
    }

    public void setCompilationDate(String compilationDate) {
        this.compilationDate = compilationDate;
    }

    @Override
    public String getSourceHash() {
        return sourceHash;
    }

    public void setSourceHash(String sourceHash) {
        this.sourceHash = sourceHash;
    }

    @Override
    public List<Interface> getInterfaces() {
        return interfaces;
    }

    @Override
    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    @Override
    public String getProtocolCompilationDate() {
        return protocolCompilationDate;
    }

    public void setProtocolCompilationDate(String protocolCompilationDate) {
        this.protocolCompilationDate = protocolCompilationDate;
    }

    @Override
    public String getProtocolSourceHash() {
        return protocolSourceHash;
    }

    public void setProtocolSourceHash(String protocolSourceHash) {
        this.protocolSourceHash = protocolSourceHash;
    }

    public void setInterfaces(List<Interface> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int getTlsPort() {
        return tlsPort;
    }

    public void setTlsPort(int tlsPort) {
        this.tlsPort = tlsPort;
    }

    @Override
    public String getWorldWideName() {
        return this.wwn;
    }

    public void setWorldWideName(String wwn) {
        this.wwn = wwn;
    }

}
