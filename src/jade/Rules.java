/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;

import java.io.Serializable;

/**
 *
 * @author Noemi
 */
public class Rules implements Serializable  {
    String[] _rules;
    
    public Rules (String[] rules){
        _rules = rules;
    }
      public String[] getRules() {
        return _rules;
    }
}
