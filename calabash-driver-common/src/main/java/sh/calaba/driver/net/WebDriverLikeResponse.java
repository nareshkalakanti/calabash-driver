/*
 * Copyright 2012 ios-driver committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package sh.calaba.driver.net;

import org.json.JSONException;
import org.json.JSONObject;

public class WebDriverLikeResponse {

  private String sessionId;
  private int status;
  private Object value;

  protected WebDriverLikeResponse() {}

  public WebDriverLikeResponse(String sessionId, int status, Object value) {
    this.sessionId = sessionId;
    this.status = status;
    this.value = value;
  }

  public WebDriverLikeResponse(JSONObject content) throws JSONException {
    this.sessionId = content.optString("sessionId");
    this.status = content.optInt("status");
    this.value = content.optJSONObject("value");
  }

  public String getSessionId() {
    return sessionId;
  }

  public int getStatus() {
    return status;
  }

  public Object getValue() {
    return value;
  }

  public String stringify() throws JSONException {
    JSONObject o = new JSONObject();
    o.put("sessionId", sessionId);
    o.put("status", status);
    o.put("value", value);
    return o.toString(2);
  }

  protected void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  protected void setStatus(int status) {
    this.status = status;
  }

  protected void setValue(Object value) {
    this.value = value;
  }

}
