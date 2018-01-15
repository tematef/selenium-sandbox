package com.selenium.sandbox.utils;

public class SelenographApi {
//    private String url = "http://" + SeleniumProperties.getProperty("selen.url");
//    private String auth;
//    private Client client;
//
//    public SelenographApi() {
//        auth = getAuthHeader("test", "test");
//        client = getClient();
//    }
//
//    public boolean isWorking() {
//        try {
//            return client.resource(url + "ping").get(ClientResponse.class).getStatus() == 200;
//        }
//        catch (ClientHandlerException e) {
//            return false;
//        }
//    }
//
//    public int getInstancesAmount() throws JSONException {
//        return client.resource(url + "quota")
//                .header("Authorization", auth)
//                .get(ClientResponse.class)
//                .getEntity(JSONObject.class).getInt("firefox:");
//    }
//
//    public boolean areInstancesAvailable(int amount) throws JSONException {
//        try {
//            JSONObject resp =  client.resource(url + "api/selenograph/quotas")
//                    .header("Authorization", auth)
//                    .get(ClientResponse.class)
//                    .getEntity(JSONObject.class).getJSONArray("all").getJSONObject(0);
//            return ((resp.getInt("max") - resp.getInt("running")) >= amount);
//        }
//        catch (Exception e)  {
//            return false;
//        }
//    }
}
