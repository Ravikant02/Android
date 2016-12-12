
package com.example.inviter.invtandroid.api.uploadResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("filePath")
    @Expose
    private String filePath;
    @SerializedName("fileType")
    @Expose
    private String fileType;
    @SerializedName("serverIp")
    @Expose
    private String serverIp;
    @SerializedName("s3FilePath")
    @Expose
    public String s3FilePath;
    @SerializedName("baseURL")
    @Expose
    public String baseURL;

    /**
     * 
     * @return
     *     The filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 
     * @param filePath
     *     The filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 
     * @return
     *     The fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 
     * @param fileType
     *     The fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 
     * @return
     *     The serverIp
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 
     * @param serverIp
     *     The serverIp
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getS3FilePath(){
        return this.s3FilePath;
    }

    public void setS3FilePath(String s3FilePath){
        this.s3FilePath = s3FilePath;
    }

    public String getBaseURL(){
        return this.baseURL;
    }

    public void setBaseURL(String baseURL)
    {
        this.baseURL = baseURL;
    }
}
