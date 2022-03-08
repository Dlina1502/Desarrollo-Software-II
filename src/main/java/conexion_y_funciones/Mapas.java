/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_y_funciones;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author cgrajales
 */
public class Mapas {
    
    private static final int MIN_ZOOM    = 0;
    private static final int MAX_ZOOM    = 21;
    private static int       zoomValue   = 4;
    private static String    apigoogle   ="AIzaSyAIESYOsg2LBnPqNdnrOy2IBQsMtWEcK-Y"; 
    private static String    apijxbrowser="1BNDHFSC1G1WRCH8W9X79TBMI8BTVQ6T9WUIGI92WBG1Z1JM8CNO0U10K4JCOD4KTG43Z2";
    String  cadenadata="";
    public Mapas(){
        System.setProperty("jxbrowser.license.key", this.apijxbrowser);
    }
    
    public void marca(String latitud, String longitud, String marca){
     Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JFrame frame = new JFrame("Mapas");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(700, 500);
            frame.setVisible(true);
        });

        browser.mainFrame().ifPresent(mainFrame -> {
            mainFrame.loadHtml("<!DOCTYPE html>\n" +
        	    "<html>\n" +
        	    "  <head>\n" +
        	    "    <title>Mapas Flash</title>\n" +
        	    "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
        	    "    <meta charset=\"utf-8\">\n" +
        	    "    <style>\n" +
        	    "      html, body, #map-canvas {\n" +
        	    "        height: 100%;\n" +
        	    "        margin: 0px;\n" +
        	    "        padding: 0px\n" +
        	    "      }\n" +
        	    "    </style>\n" +
        	    "    <script src=\"https://maps.googleapis.com/maps/api/js?key="+this.apigoogle+"&sensor=false\"></script>\n" +
        	    "    <script>\n" +
        	    "var map;\n" +
        	    "function initialize() {\n" +
        	    "  var mapOptions = {\n" +
        	    "    zoom: 4,\n" +
        	    "    center: new google.maps.LatLng(\n"+latitud+", \n"+longitud+")\n" +
        	    "  };\n" +
        	    "  map = new google.maps.Map(document.getElementById('map-canvas'),\n" +
        	    "      mapOptions);\n" +
        	    "  marker = new google.maps.Marker({position: new google.maps.LatLng(\n"+latitud+", \n"+longitud+"), map: map}); \n\n"+
        	    "}\n" +
        	    "\n" +
        	    "google.maps.event.addDomListener(window, 'load', initialize);\n" +
        	    "\n" +
        	    "    </script>\n" +
        	    "  </head>\n" +
        	    "  <body>\n" +
        	    "    <div id=\"map-canvas\"  style=\"width: 700px; height: 470px;\"></div>\n" +
        	    "  </body>\n" +
        	    "</html>");
        });
        
    }
    
    
    public void marcas(Marker[] marker){
        multiplesmarcas( marker,null);
    }
    
    public void marcas(Marker[] marker,JPanel panel){
        multiplesmarcas( marker, panel);
    }
    
    public void multiplesmarcas(Marker [] marker, JPanel panel){
     Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            if (Objects.isNull(panel)){
                JFrame frame = new JFrame("Mapa");
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frame.add(view, BorderLayout.CENTER);
                frame.setSize(700, 500);
                frame.setVisible(true);
            }
            else {
                panel.add(view, BorderLayout.CENTER);
            }
        });
        
        String latitud= marker[0].latitud;
        String longitud= marker[0].longitud;
        
        cadenadata="var markers  = [\n";
        
        for (int i=0;i<marker.length;i++) {
            cadenadata = cadenadata+"       {lat: '" + marker[i].latitud + "' , lng: '" + marker[i].longitud + "', name: '" + marker[i].nombre + "',  address: '" + marker[i].direccion + "',   description: '" + marker[i].informacion + "'}";
            if(i!=(marker.length-1))
                cadenadata=cadenadata+",\n";
        }
           cadenadata=cadenadata+"   ];\n";
        

        browser.mainFrame().ifPresent(mainFrame -> {
            String cadena="<!DOCTYPE html>\n" +
        	    "<html>\n" +
        	    "  <head>\n" +
        	    "    <title>Mapas Flash</title>\n" +
        	    "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
        	    "    <meta charset=\"utf-8\">\n" +
        	    "    <style>\n" +
        	    "      html, body, #map-canvas {\n" +
        	    "        height: 100%;\n" +
        	    "        margin: 0px;\n" +
        	    "        padding: 0px\n" +
        	    "      }\n" +
        	    "    </style>\n" +
        	    "    <script src=\"https://maps.googleapis.com/maps/api/js?key="+this.apigoogle+"&sensor=false\"></script>\n" +
        	    "    <script>\n" +

                    
                    "function initialize() { \n"+
                    "    var infoWindow = new google.maps.InfoWindow();\n"+
                    "    var myCenter=new google.maps.LatLng("+latitud+","+longitud+");\n"+
                    "    var mapOptions = {\n"+
                    "        center: myCenter,\n"+
                    "        zoom: 6,\n"+
                    "        mapTypeId: google.maps.MapTypeId.ROADMAP,\n"+
                    "    };\n"+
                    "    var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);\n"+
                         cadenadata+
                    "   setmarker(markers,map,infoWindow)\n"+   
                    "}\n"+

                    "google.maps.event.addDomListener(window, 'load', initialize);\n"+                  
                    "function setmarker(markers,map,infoWindow){\n"+
                    "        for (var i = 0; i < markers.length; i++) {\n"+
                    "            var data = markers[i];\n"+
                    "            var myLatlng = new google.maps.LatLng(data.lat, data.lng);\n"+
                    "            var marker = new google.maps.Marker({\n"+
                    "                position: myLatlng,\n"+
                    "                map: map,\n"+
                    "                title: data.title\n"+
                    "            });\n"+           
                    "            (function (marker, data) {\n"+
                    "                google.maps.event.addListener(marker, 'click', function (e) {\n"+                 
                    "                    infoWindow.setContent(\"<div style = 'width:200px;min-height:40px'>\" + data.description + \"</div>\");\n"+
                    "                    infoWindow.open(map, marker);\n"+
                    "                });\n"+
                    "            })(marker, data);\n"+
                    "        }\n"+
                    "}"+
                    
                    "</script>\n" +
        	    "  </head>\n" +
        	    "  <body>\n" +
        	    "    <div id=\"map-canvas\"  style=\"width: 100%; height: 100%;\"></div>\n" +
        	    "  </body>\n" +
        	    "</html>";
            //System.out.println(cadena);
            mainFrame.loadHtml(cadena);
        });	
	
    }
    
 
    public void geocoder(String [] direccion, JPanel panel){
     Engine engine = Engine.newInstance(HARDWARE_ACCELERATED);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            if (Objects.isNull(panel)){
                JFrame frame = new JFrame("Mapa");
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frame.add(view, BorderLayout.CENTER);
                frame.setSize(700, 500);
                frame.setVisible(true);
            }
            else {
                panel.add(view, BorderLayout.CENTER);
            }
        });
      
        browser.mainFrame().ifPresent(mainFrame -> {
            String cadena="<!DOCTYPE html>\n" +
        	    "<html>\n" +
        	    "  <head>\n" +
        	    "    <title>Mapas Flash</title>\n" +
        	    "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
        	    "    <meta charset=\"utf-8\">\n" +
        	    "    <style>\n" +
        	    "      html, body, #map-canvas {\n" +
        	    "        height: 100%;\n" +
        	    "        margin: 0px;\n" +
        	    "        padding: 0px\n" +
        	    "      }\n" +
        	    "    </style>\n" +
        	    "    <script src=\"https://maps.googleapis.com/maps/api/js?key="+this.apigoogle+"&sensor=false\"></script>\n" +
        	    "    <script>\n" +

                    "	var geocoder;\n"+
                    "    var map;\n"+
                    "    function initialize() {\n"+
                    "      geocoder = new google.maps.Geocoder();\n"+
                    "     var latlng = new google.maps.LatLng(-34.397, 150.644);\n"+
                    "      var mapOptions = {\n"+
                    "        zoom: 8,\n"+
                    "        center: latlng\n"+
                    "      }\n"+
                    "      map = new google.maps.Map(document.getElementById('map'), mapOptions);\n"+
                    "    }\n"+

                    "    function codeAddress() {\n";
                    
                    for(int z=0;z<direccion.length;z++){
                    
                        cadena+="      geocoder.geocode( { 'address': '"+direccion[z]+"'}, function(results, status) {\n"+
                    "        if (status == 'OK') {\n"+
                    "          map.setCenter(results[0].geometry.location);\n"+
                    "          var marker = new google.maps.Marker({\n"+
                    "              map: map,\n"+
                    "              position: results[0].geometry.location\n"+
                    "          });\n"+
                    "        } else {\n"+
                    "          alert('Geocode was not successful for the following reason: ' + status);\n"+
                    "        }\n"+
                    "      });\n";
                    }

                    cadena+="    }\n"+
                    "</script>\n" +
        	    "  </head>\n" +
        	    "<body onload=\"initialize();codeAddress()\">\n" +
                    "<div id='map' style='width: 100%; height: 100%;'></div>\n" +
                    "</body>\n" +
                    "</html>";
            System.out.println(cadena);
            mainFrame.loadHtml(cadena);
        });	
	
    }
    
    
}


