package com.raven.model;

import com.raven.event.EventFileSender;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class Model_Receive_Image {

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Model_Receive_Image(int fileID, String image, int width, int height) {
        this.fileID = fileID;
        this.image = image;
        this.width = width;
        this.height = height;
    }

    public Model_Receive_Image(Object json) {
    JSONObject obj = (JSONObject) json;
    try {
        if (obj.has("fileID") && obj.has("image") && obj.has("width") && obj.has("height")&&obj.has("path")) {
            fileID = obj.getInt("fileID");
            image = obj.getString("image");
            width = obj.getInt("width");
            height = obj.getInt("height");
            path=obj.getString("path");
        } else {
            System.err.println("One or more keys are missing in the JSON object.");
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
}


    private int fileID;
    private String image;
    private int width;
    private int height;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    private EventFileSender event;
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();

        try {
            json.put("fileID", fileID);
            if (image != null) {
                json.put("image", image);
            }
            json.put("path", path);

            json.put("width", width);
            json.put("height", height);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
   
}
