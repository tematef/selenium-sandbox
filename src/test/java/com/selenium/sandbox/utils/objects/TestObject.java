package com.selenium.sandbox.utils.objects;


import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class TestObject {

    private Openvswitch openvswitch;
//    @JsonProperty("ovn-northbound")
    @SerializedName("ovn-northbound")
    private Map<String,String> var;
    private String mode;
    private String version;

    public TestObject(String mode, String version) {
        this.mode = mode;
        this.version = version;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Openvswitch getOpenvswitch() {
        return openvswitch;
    }

    public void setOpenvswitch(Openvswitch openvswitch) {
        this.openvswitch = openvswitch;
    }


//    public Map<String, String> getOvnnorthbound() {
//        return ovnnorthbound;
//    }
//
//    public void setOvnnorthbound(Map<String, String> ovnnorthbound) {
//        this.ovnnorthbound = ovnnorthbound;
//    }

    class Openvswitch {
        private boolean running;
        private String version;

        public boolean isRunning() {
            return running;
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
