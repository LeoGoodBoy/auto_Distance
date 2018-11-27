/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otodistances;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Calculation {
    
    private String[] apiKey;
    
    public Calculation(){
            
        String[] apiKey = {

//            "AIzaSyDwMf2LMHnLsvxSlMv4S4G8_QBCcB649HE", //1568-1571
//            "AIzaSyDmqo9jLIYNngpIwT2eK0EOyJOo4q6St88",//1572-1575
//            "AIzaSyBgJXUDBvXLEl-xTEYbjVCKZ_98bUvrFSE",//1576-1579
//            "AIzaSyAjEmlmU2A2EqlMMJ8FVF5SbugO98HC0ss",//1580-1583
//            "AIzaSyCvWrkjE4dgPE9_gJ0n-v08YD34pOW336Y",//1584-1587
//            "AIzaSyDP4_dUEUC8um4ozhVOe9MMa6L1yiUO6tk",//1588-1591
//            "AIzaSyBpqdoL3Fqtmvcb4UqEJqBR3hB-JdVgs_w",//1592-1595
//            "AIzaSyAWxlVI7o75HuUVsIvdypWXtYPhk0xSu-g",//1596-1599
//            "AIzaSyB8-CtA47fVb9Xs8gO46ZPw7ap29RWMK9g",//1600-1603
//            "AIzaSyDAH32DonLXYf_jGq-VV3rnj8wkDSm0Asw",//1604-1607
//            "AIzaSyAmsf242-IrYkiYLhMBUdr5eXbFTgTCDaM",//1608-1611
//            "AIzaSyBGgjTVPZiMLr4YLZavBKk76XigX6kfO_c",//1612-1615
//            "AIzaSyBUWet7ilmB8NjEG7OJ6jUCIVIBTiPRXUA",//1616-1619
//            "AIzaSyDRRrIJfhbFkF6g14mrxUlrncV-3owFbWY",//1620-1623
//            "AIzaSyADrpFpLepcUSoIx7T0DRx-YjTu233B4Vg",//1624-1627
//            "AIzaSyBekFwZuqD9I1NRIvp_QwLz-rBKRVlMzX4",
//            "AIzaSyDpyrzjybnC9bG0IlmLfVwMjeuLCqWw2tM",
//            "AIzaSyCbG5GS9Qz8J4jWwWweT5CkWf1PHn3ohQA",
//            "AIzaSyClwalNvhQWy01xK-tYlksD8D7z7K9-rYg",
//            "AIzaSyBPS5Oav-fti73DJZ4V0PJcD60o78CqTRg",
//            "AIzaSyAscnruEZDALhohF7Olzul5h5dOW9_pIPs",
//            "AIzaSyCzcEmKYP17DBNtoHq0Yin56K3AgJxDrRE",
//            "AIzaSyD6H96p2RQfe4u7BwWbucjebSzpkBA7pYU",
//            "AIzaSyDhci-g90LLssbA4nlAvbQQNw-uX86rXwk",
//            "AIzaSyBdHGCU4nf3X59acD7uC-_tCVuivPWygRk",
//            "AIzaSyAxj3ewg7dSaoHJMZYA9Xgf8Qi7S9m8Frk",
//            "AIzaSyD16qBI2zm4iDEdSqThrswoNhM6waS1f68",//1675
//            "AIzaSyCgv5vXHsHid4rfV6esoCdttRerDCxHlgQ",
//            "AIzaSyCf0R_xnulSAwLVUw9MgSFUwsKApfOAMwY",
//            "AIzaSyCvrKg8W5R7_TWBp4GlxkETJlVTnOA2EKE",
//            "AIzaSyDnWUYY6VxrErErLZrIq-YqN0a_O3OKVtc",
//            "AIzaSyCiBl2y0b45EjSXNC5MAETnCGdT_cS-uOw",
//            "AIzaSyDckVVS0H3QAk4MtG7jcfea3U9YGcPnZrQ",//renew end
//            "AIzaSyAeI9CZbKLllsV34YSWDs4doacC031xU5c",
//            "AIzaSyD0S4KL-Jy5B_A5ITvSX_XXTYcoKaHDW3Q",
//            "AIzaSyCY_rqniMDHfQQ0YJpe4KytjcS3YZs1itU",
//            "AIzaSyAFGfyUEyEDzHEkiHbtlDrIgKkE6D0XRSI",
//            "AIzaSyAMEGERbb2R9K8FXk1E16uIj6OptDdNVu8",
//            "AIzaSyCaxiAdcFAipZ_h86e_yj_U5eFtuyEXtwk",
//            "AIzaSyClvHYiFtzXhlHlpP1t9-6G12W8ndX_mA0",
//            "AIzaSyBMchcyTlp_VNBcZFHP_lhbmMf-mRbHohU",
//            "AIzaSyC1DgyEoopRtV2Qh46qraUN9gojLpQJRGM",
//            "AIzaSyB9ezZNNrDX5Im4jVfb04UDUavZ2uC7Coo",
//            "AIzaSyArPf2Bm2tJynfZpFUM6WGPw9Xr6DP0MpA",
//            "AIzaSyCtf7ZGdjDRSHad4SYmYeecEZPKD6mh5wQ",
//            "AIzaSyDtsstm7SPtzKdny9qD2n2U8L-SrctR250",
//            "AIzaSyBpMHfO7b-8FgIu5D4u_JDgyb_56pBphd8",
//            "AIzaSyCqaqdR6w3_OqRdVZcQIJkFfj9jPL4QkEU",
//            "AIzaSyCgm24_0xoerJer_XzEtBEoCq1s6mXt9ng",
//            "AIzaSyBcI7H-Ft9PRFUBkOee8p03RMW50IdILbE",
//            "AIzaSyBXeiuMSkAECYErpGFGoh80WftEUQe8dw0",
//            "AIzaSyDw13XEr346haqm7GxIRA_wmnJvfrx1V04",
//            "AIzaSyB7M_shhYP7y-NWljFnnLO-va9YGAa4vYc",
//            "AIzaSyBhSrLiySMIJITg_DJau3T557oDxjWwRIk",
//            "AIzaSyDxyJ0U02aX5XQ1AzhQwhPK5vUF-jxbg5k",
//            "AIzaSyCkMnynng8PrPJUlH_ipLgKAGLSew7Ny9w",
//            "AIzaSyBWsXH8yUKzBSJYe-HWEoQ7IFVhr15hDI8",
            "AIzaSyBENUvIXFmzZHkY0Wn-XbhkZIraBzPCHO4",
            "AIzaSyA-s1_pAbs-i3in6q5ZdLU4nMCOJdLH3sQ",
            "AIzaSyC_VYR0Ng_YgfC6zAk5_rdVwvp4dwA98U0",
            "AIzaSyBoXwHel3C_5G7kvEf0QMU4jD2OdR8D7yE",
            "AIzaSyCHJ8EFcE43bPcTNrO6MHwunU8mX9riods",
            "AIzaSyA_5SWzqD6TIV3-dnnaiTWsazUeL3Xcv14",
            "AIzaSyAKwLrW54f_DHU34STm3iWDJnQKBdhLUDQ",
            "AIzaSyDrnkYS8tGZHu099N1kR2weceACXjmGOeI",
            "AIzaSyDZ64nsjgrTHnSZWB2f_9cvyFBeGEA0X14",
            "AIzaSyCjqHotC3AJ0XdQmVGfcI1BI7ZfDldMym4",
            "AIzaSyCXh-gCknb1YDjX_CYWJJ8aV8h5_MsTRNM",
            "AIzaSyB0OgGxT7PWkE6Ifr0YuaZdxob8f0PS4UE",
            "AIzaSyA0B6ZiTkBhzYsoWS-qbWipbqE4RK4cpNg",
            "AIzaSyA3gOnWr5X3DhKa2fwt16TiCiy6ggjrTVo",
            "AIzaSyC6ngUB_uRQJKSqmJhrTDfQy5BZGoIqV7I",
            "AIzaSyCK0hluaWo0Rfwt1u_YPzDUeBTp_7KKNO0",
            "AIzaSyDT-AxGT7yXH0jV7l-KQXdMyfCilJvFrDA",
            "AIzaSyDD6pfLkH_fbzkUHIusSVY9b4GEIJcrky4",
            "AIzaSyAqaYm01OGWXws6dBMhKUR-h_7WQtgxi78",
            "AIzaSyCxJhVu9lRWHurxdmu_i3UE00Wd-IgJng0",
            "AIzaSyCoOE6Y3Pik0ohbtpDjt_RLU8h8GJj3Ve4",
            "AIzaSyBqxd78wnp-lyUxv8ovqYqFYxNwugNr7so",
            "AIzaSyC_zvQmFaufYX1aKDUr_iJ2j3CaWGLuCyU",
            "AIzaSyBI-90GCYoOTvYvRHaCA8IfonzFNnk4Nrk",
            "AIzaSyBjUgMvUsBCfFKjIsCwyC_HWC6NkbG7Nog"
        };

        this.apiKey = apiKey;
    }
    
    public String getApiKey(int index){
        return apiKey[index];
    }
    
    public double getDistanceGoogleAPI(Location origin, Location destination, String apiKey){
        double distance = 0.0;
        String strDist = "";
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?units=metric"
                    + "&origins="+origin.getLatitude()+","+origin.getLongitude()
                    + "&destinations="+destination.getLatitude()+","+destination.getLongitude()
                    + "&key="+apiKey);
            
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            InputStream is = httpConn.getInputStream();
            JsonReader rdr = Json.createReader(is);

            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("rows");
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                JsonArray results2 = result.getJsonArray("elements");
                for (JsonObject result2 : results2.getValuesAs(JsonObject.class)) {
                    if(!result2.getString("status").equals("ZERO_RESULTS")){
                        distance=result2.getJsonObject("distance").getInt("value"); 
                    }
                }
            }
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(Calculation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return distance;
    }
}
