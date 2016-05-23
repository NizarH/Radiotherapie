/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio.HDSObjects;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author mgkersloot
 */
public class HDSData {
    
    private int dhNumber;
    private String realTime, elapsedTime, dataType;
    private TreeMap<String, String> values;
    
    public HDSData(int givenDhNumber, String givenRealTime, String givenElapsedTime)
    {
        dhNumber = givenDhNumber;
        realTime = givenRealTime;
        elapsedTime = givenElapsedTime;
        values = new TreeMap<>();
    }
    
    public void setDataType(String givenDataType)
    {
        dataType = givenDataType;
    }
    
    public void addValue(String type, String value)
    {
        values.put(type, value);
    }
}
