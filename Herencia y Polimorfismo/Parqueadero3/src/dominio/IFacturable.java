/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dominio;

/**
 *
 * @author Jairo F
 */
public interface IFacturable {
    
    public abstract String getType();
    public abstract double getRecargo();
    public abstract double getTarifa();
    
}
