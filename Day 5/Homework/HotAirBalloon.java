import java.util.*;

/**
 * Purpose: This program is used to store and print imformation of hot air balloon.
 *                                                                    <br>
 * Date:    October 15, 2017
 * @author  Lingfei Li
 * @version 1.0
 */
public class HotAirBalloon extends Vehicle
{

   private int balloonBasketColor=0;
   private int balloonPower=0;
   private String balloonBasketColorQuestion = "What color of basket of hot air balloon is this?";
   private String balloonPowerQuestion = "What power of ot air balloon is this?";
   final String [] BALLOONBASKETCOLOR = {"Red","Yellow","Black"};
   final String [] BALLOONPOWER = {"Montgolfier","Hybrid","Solar"};
   final Double [] BALLOONMILEAGE = {24.0, 3.0, 0.0};



   /**constructor method*/
   public HotAirBalloon()
   {
      balloonBasketColor = super.showMenu(balloonBasketColorQuestion, BALLOONBASKETCOLOR);
      balloonPower = super.showMenu(balloonPowerQuestion, BALLOONPOWER);
   }

   /**return gas mileage method*/
   public double gasMileage()
   {
      return BALLOONMILEAGE[getBalloonPower()-1];
   }



      /**get value method*/

   public int getBalloonBasketColor()
   {
      return balloonBasketColor;
   }

   public int getBalloonPower()
   {
      return balloonPower;
   }

      /**set value method*/

   public void setBalloonBasketColor(int balloonBasketColor)
   {
      this.balloonBasketColor = balloonBasketColor;
   }

   public void setBalloonPower(int balloonPower)
   {
      this.balloonPower = balloonPower;
   }



   /** return information string to Vehicle*/
   public String toString()
   {

      String returnInfo = super.toString();
      returnInfo  += (String.format("\t   %-10s", "Basket Color: ") + String.format("%-15s \n",BALLOONBASKETCOLOR[getBalloonBasketColor()-1])
      + String.format("\t   %-10s", "Power: ") + String.format("%-10s \n",BALLOONPOWER[getBalloonPower()-1]));
      return returnInfo;
   }



} // end class HotAirBalloon
