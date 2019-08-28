

package com.example.nettotestdesign;

public class Steuerberechnung 
{
	double kirchensteuer; 
	private double brutto, netto, auszahlung, kirchensteuersatz, zeitraumteiler = 1, rentenversicherung = 0, krankenversicherung = 0, arbeitslosenversicherung = 0, pflegeversicherung = 0, arbeitskammerbeitrag = 0;
	private int alter = 0;
	
	private static double RENTBEMESSUNGSGR_WEST_2013 = 69600;
	private static double RENTBEMESSUNGSGR_OST_2013 = 58800;	
	private static double RENTBEMESSUNGSGR_WEST_2014 = 71400;
	private static double RENTBEMESSUNGSGR_OST_2014 = 60000;	
	private static double RENTBEMESSUNGSGR_WEST_2015 = 72600;
	private static double RENTBEMESSUNGSGR_OST_2015 = 62400;
	private static double RENTBEMESSUNGSGR_WEST_2016 = 74400;
	private static double RENTBEMESSUNGSGR_OST_2016 = 64800;
	private static double RENTBEMESSUNGSGR_WEST_2017 = 76200;
	private static double RENTBEMESSUNGSGR_OST_2017 = 68400;
	private static double RENTBEMESSUNGSGR_WEST_2018 = 78000;
	private static double RENTBEMESSUNGSGR_OST_2018 = 69600;	
	private static double RENTBEMESSUNGSGR_WEST_2019 = 80400;
	private static double RENTBEMESSUNGSGR_OST_2019 = 73800;
	private static double KORREKTURFAKTOR_VSP_2013 = 0.52;
	private static double KORREKTURFAKTOR_VSP_2014 = 0.56;
	private static double KORREKTURFAKTOR_VSP_2015 = 0.60;
	private static double KORREKTURFAKTOR_VSP_2016 = 0.64;
	private static double KORREKTURFAKTOR_VSP_2017 = 0.68;
	private static double KORREKTURFAKTOR_VSP_2018 = 0.72;	
	private static double KORREKTURFAKTOR_VSP_2019 = 0.76;
	private static double RENT_SATZ_vor2015 = 18.9;	
	private static double RENT_SATZ_2015 = 18.7;
    private static double RENT_SATZ_2016 = 18.7;
    private static double RENT_SATZ_2017 = 18.7;
	private static double RENT_SATZ_2018 = 18.6;
	private static double RENT_SATZ_2019 = 18.6;
	private static double KV_GRENZ_2013 = 47250;	
	private static double KV_GRENZ_2014 = 48600;	
	private static double KV_GRENZ_2015 = 49500;
	private static double KV_GRENZ_2016 = 50850;
	private static double KV_GRENZ_2017 = 52200;
	private static double KV_GRENZ_2018 = 53100;
	private static double KV_GRENZ_2019 = 54450;
	private static double RENTENVERS_SATZ_AN_vor2015 = 0.0945;	
	private static double RENTENVERS_SATZ_AN_nach2015 = 0.0935;	
	private static double RENTENVERS_SATZ_AN_ab2018 = 0.093;	
	//vorsichtig understand und ersetzen 
	private static double RENTENVERS_SATZ_AN_ab2019 = 0.093;
	//ACHTUNG: KV-S�tze zur steuerlichen Berechnung sind die erm��igten S�tze! "Normals�tze" sind jeweils +0,3 
	private static double KV_SATZ_AN_vor2015 = 7.9;
	private static double KV_SATZ_AN_2015 = 7.0;
    private static double KV_SATZ_AN_2016 = 7.0;
    private static double KV_SATZ_AN_2017 = 7.0;    
	private static double KV_SATZ_AN_2018 = 7.0;	
	private static double KV_SATZ_AN_2019 = 7.0;
	private static double KV_SATZ_AG_vor2015 = 7.0;
	private static double KV_SATZ_AG_2015 = 7.0;
    private static double KV_SATZ_AG_2016 = 7.0;
    private static double KV_SATZ_AG_2017 = 7.0;
    private static double KV_SATZ_AG_2018 = 7.0;    
	private static double KV_SATZ_AG_2019 = 7.0;
	private static double PV_SATZ_AN_vor2015 = 1.025;
	private static double PV_SATZ_AN_2015 = 1.175;
    private static double PV_SATZ_AN_2016 = 1.175;
    private static double PV_SATZ_AN_2017 = 1.275;
	private static double PV_SATZ_AN_2018 = 1.275;	
	private static double PV_SATZ_AN_2019 = 1.525;
	private static double PV_SATZ_AG_vor2015 = 1.025;
	private static double PV_SATZ_AG_2015 = 1.175;
    private static double PV_SATZ_AG_2016 = 1.175;
    private static double PV_SATZ_AG_2017 = 1.275;
	private static double PV_SATZ_AG_2018 = 1.275;
	private static double PV_SATZ_AG_2019 = 1.525;
	private static double KINDERFREIBETRAG_vor2015 = 7004;
	private static double KINDERFREIBETRAG_2015 = 7152;
    private static double KINDERFREIBETRAG_2016 = 7248;
    private static double KINDERFREIBETRAG_2017 = 7356;
    private static double KINDERFREIBETRAG_2018 = 7428;
	private static double KINDERFREIBETRAG_2019 = 7620;
	private static double ALLEINERZ_FREIBETRAG_vor2016 = 1308;	
	private static double ALLEINERZ_FREIBETRAG_ab2016 = 1908;
	private static double ALLEINERZ_FREIBETRAG_ab2019 = 1908;
	private static double GRENZW1_STKL5_2013 = 9550;	
	private static double GRENZW1_STKL5_2014 = 9763;
	private static double GRENZW1_STKL5_2015 = 9763;
    private static double GRENZW1_STKL5_2016 = 10070;
    private static double GRENZW1_STKL5_2017 = 10240;
	private static double GRENZW1_STKL5_2018 = 10440;
	private static double GRENZW1_STKL5_2019 = 10635;
    private static double GRENZW2_STKL5_vor2016 = 26441;
    private static double GRENZW2_STKL5_2016 = 26832;
    private static double GRENZW2_STKL5_2017 = 27029;
	private static double GRENZW2_STKL5_2018 = 27475;
	private static double GRENZW2_STKL5_2019 = 27980;
	private static double GRENZW3_STKL5_vor2016 = 200584;
    private static double GRENZW3_STKL5_2016 = 203557;
    private static double GRENZW3_STKL5_2017 = 205043;
    private static double GRENZW3_STKL5_2018 = 208426;
	private static double GRENZW3_STKL5_2019 = 212261;
    private static double GRUNDFREIBETRAG_2016 = 8652;
    private static double GRUNDFREIBETRAG_2017 = 8820;
	private static double GRUNDFREIBETRAG_2018 = 9000;	
	private static double GRUNDFREIBETRAG_2019 = 9168;

	
	private static double ARB_SATZ = 3.0;
	private boolean istWestAN, istSachsenAN;
	
	//Hier je nach gew�hltem Jahr den variablen Werte zuweisen:
	private double RENTBEMESSUNGSGR_WEST;
	private double RENTBEMESSUNGSGR_OST;
	private double KORREKTURFAKTOR_VSP;
	private double KV_GRENZ;
	private int AKTUELLES_JAHR;
	private double RENTENVERS_SATZ_AN; //unterschiedlich ab 2015	
	private double KV_SATZ_AG;  //unterschiedlich ab 2015	
	private double KV_SATZ_AN;  //unterschiedlich ab 2015	
	private double PV_SATZ_AG;  //unterschiedlich ab 2015	
	private double PV_SATZ_AN;  //unterschiedlich ab 2015	
	private double RENT_SATZ;   //unterschiedlich ab 2015	
	private double KINDERFREIBETRAG;   //unterschiedlich ab 2016 (nachtr�glich auch f�r 2015)	
	private double ALLEINERZ_FREIBETRAG;   //unterschiedlich ab 2016
	private double GRENZW1_STKL5;   //unterschiedlich ab 2016
	private double GRENZW2_STKL5;   //unterschiedlich ab 2016
	private double GRENZW3_STKL5;   //unterschiedlich ab 2016
    private double GRUNDFREIBETRAG; //eingef�hrt ab 2016
	
	//public enum ZeitraumType { JAHR, MONAT, WOCHE, TAG };
	//public enum BundeslandType { NDS, SHW, SAAR, NRW, HH, BRE, HES, RPF, BW, BAY, MVO, BRA, BER, SA, SAAN, THUER };
	String  ZeitraumType="MONAT";
	String   bundesland="HESSEN";
	
	//public Steuerberechnung( ZeitraumType zeitraum, BundeslandType bundesland, int jahr )
	public Steuerberechnung( String zeitraum, String  bundesland, int jahr )
	{
		//jahresabh�ngige Werte anpassen
		switch( jahr )
		{
		case 2013:
			AKTUELLES_JAHR = 2013;
			RENTBEMESSUNGSGR_WEST = RENTBEMESSUNGSGR_WEST_2013;
			RENTBEMESSUNGSGR_OST = RENTBEMESSUNGSGR_OST_2013;
			KORREKTURFAKTOR_VSP = KORREKTURFAKTOR_VSP_2013;
			KV_GRENZ = KV_GRENZ_2013;
			RENTENVERS_SATZ_AN = RENTENVERS_SATZ_AN_vor2015;
			KV_SATZ_AG = KV_SATZ_AG_vor2015;
			KV_SATZ_AN = KV_SATZ_AN_vor2015;			
			PV_SATZ_AG = PV_SATZ_AG_vor2015;
			PV_SATZ_AN = PV_SATZ_AN_vor2015;
			RENT_SATZ = RENT_SATZ_vor2015;
			KINDERFREIBETRAG = KINDERFREIBETRAG_vor2015;
			ALLEINERZ_FREIBETRAG = ALLEINERZ_FREIBETRAG_vor2016;
			GRENZW1_STKL5 = GRENZW1_STKL5_2013;			
			GRENZW2_STKL5 = GRENZW2_STKL5_vor2016;
			GRENZW3_STKL5 = GRENZW3_STKL5_vor2016;
			break;
			
		case 2014:
			AKTUELLES_JAHR = 2014;
			RENTBEMESSUNGSGR_WEST = RENTBEMESSUNGSGR_WEST_2014;	
			RENTBEMESSUNGSGR_OST = RENTBEMESSUNGSGR_OST_2014;
			KORREKTURFAKTOR_VSP = KORREKTURFAKTOR_VSP_2014;
			KV_GRENZ = KV_GRENZ_2014;
			RENTENVERS_SATZ_AN = RENTENVERS_SATZ_AN_vor2015;
			KV_SATZ_AG = KV_SATZ_AG_vor2015;
			KV_SATZ_AN = KV_SATZ_AN_vor2015;			
			PV_SATZ_AG = PV_SATZ_AG_vor2015;
			PV_SATZ_AN = PV_SATZ_AN_vor2015;
			RENT_SATZ = RENT_SATZ_vor2015;
			KINDERFREIBETRAG = KINDERFREIBETRAG_vor2015;
			ALLEINERZ_FREIBETRAG = ALLEINERZ_FREIBETRAG_vor2016;
			GRENZW1_STKL5 = GRENZW1_STKL5_2014;			
			GRENZW2_STKL5 = GRENZW2_STKL5_vor2016;
			GRENZW3_STKL5 = GRENZW3_STKL5_vor2016;
			break;	
			
		case 2015:
			AKTUELLES_JAHR = 2015;
			RENTBEMESSUNGSGR_WEST = RENTBEMESSUNGSGR_WEST_2015;	
			RENTBEMESSUNGSGR_OST = RENTBEMESSUNGSGR_OST_2015;
			KORREKTURFAKTOR_VSP = KORREKTURFAKTOR_VSP_2015;
			KV_GRENZ = KV_GRENZ_2015;
			RENTENVERS_SATZ_AN = RENTENVERS_SATZ_AN_nach2015;
			KV_SATZ_AG = KV_SATZ_AG_2015;
			KV_SATZ_AN = KV_SATZ_AN_2015;			
			PV_SATZ_AG = PV_SATZ_AG_2015;
			PV_SATZ_AN = PV_SATZ_AN_2015;
			RENT_SATZ = RENT_SATZ_2015;
			KINDERFREIBETRAG = KINDERFREIBETRAG_2015;
			ALLEINERZ_FREIBETRAG = ALLEINERZ_FREIBETRAG_vor2016;
			GRENZW1_STKL5 = GRENZW1_STKL5_2015;			
			GRENZW2_STKL5 = GRENZW2_STKL5_vor2016;
			GRENZW3_STKL5 = GRENZW3_STKL5_vor2016;
			break;

		case 2016:
			AKTUELLES_JAHR = 2016;
			RENTBEMESSUNGSGR_WEST = RENTBEMESSUNGSGR_WEST_2016;
			RENTBEMESSUNGSGR_OST = RENTBEMESSUNGSGR_OST_2016;
			KORREKTURFAKTOR_VSP = KORREKTURFAKTOR_VSP_2016;
			KV_GRENZ = KV_GRENZ_2016;
			RENTENVERS_SATZ_AN = RENTENVERS_SATZ_AN_nach2015;
			KV_SATZ_AG = KV_SATZ_AG_2016;
			KV_SATZ_AN = KV_SATZ_AN_2016;
			PV_SATZ_AG = PV_SATZ_AG_2016;
			PV_SATZ_AN = PV_SATZ_AN_2016;
			RENT_SATZ = RENT_SATZ_2016;
			KINDERFREIBETRAG = KINDERFREIBETRAG_2016;
			ALLEINERZ_FREIBETRAG = ALLEINERZ_FREIBETRAG_ab2016;
			GRENZW1_STKL5 = GRENZW1_STKL5_2016;
			GRENZW2_STKL5 = GRENZW2_STKL5_2016;
			GRENZW3_STKL5 = GRENZW3_STKL5_2016;
            GRUNDFREIBETRAG = GRUNDFREIBETRAG_2016;
			break;

        case 2017:
            AKTUELLES_JAHR = 2017;
            RENTBEMESSUNGSGR_WEST = RENTBEMESSUNGSGR_WEST_2017;
            RENTBEMESSUNGSGR_OST = RENTBEMESSUNGSGR_OST_2017;
            KORREKTURFAKTOR_VSP = KORREKTURFAKTOR_VSP_2017;
            KV_GRENZ = KV_GRENZ_2017;
            RENTENVERS_SATZ_AN = RENTENVERS_SATZ_AN_nach2015;
            KV_SATZ_AG = KV_SATZ_AG_2017;
            KV_SATZ_AN = KV_SATZ_AN_2017;
            PV_SATZ_AG = PV_SATZ_AG_2017;
            PV_SATZ_AN = PV_SATZ_AN_2017;
            RENT_SATZ = RENT_SATZ_2017;
            KINDERFREIBETRAG = KINDERFREIBETRAG_2017;
            ALLEINERZ_FREIBETRAG = ALLEINERZ_FREIBETRAG_ab2016;
            GRENZW1_STKL5 = GRENZW1_STKL5_2017;
            GRENZW2_STKL5 = GRENZW2_STKL5_2017;
            GRENZW3_STKL5 = GRENZW3_STKL5_2017;
            GRUNDFREIBETRAG = GRUNDFREIBETRAG_2017;
            break;
		
        case 2018:
            AKTUELLES_JAHR = 2018;
            RENTBEMESSUNGSGR_WEST = RENTBEMESSUNGSGR_WEST_2018;
            RENTBEMESSUNGSGR_OST = RENTBEMESSUNGSGR_OST_2018;
            KORREKTURFAKTOR_VSP = KORREKTURFAKTOR_VSP_2018;
            KV_GRENZ = KV_GRENZ_2018;
            RENTENVERS_SATZ_AN = RENTENVERS_SATZ_AN_ab2018;
            KV_SATZ_AG = KV_SATZ_AG_2018;
            KV_SATZ_AN = KV_SATZ_AN_2018;
            PV_SATZ_AG = PV_SATZ_AG_2018;
            PV_SATZ_AN = PV_SATZ_AN_2018;
            RENT_SATZ = RENT_SATZ_2018;
            KINDERFREIBETRAG = KINDERFREIBETRAG_2018;
            ALLEINERZ_FREIBETRAG = ALLEINERZ_FREIBETRAG_ab2016;
            GRENZW1_STKL5 = GRENZW1_STKL5_2018;
            GRENZW2_STKL5 = GRENZW2_STKL5_2018;
            GRENZW3_STKL5 = GRENZW3_STKL5_2018;
            GRUNDFREIBETRAG = GRUNDFREIBETRAG_2018;
            break;        
			
		default: //latest year
        case 2019:
            AKTUELLES_JAHR = 2019;
            RENTBEMESSUNGSGR_WEST = RENTBEMESSUNGSGR_WEST_2019;
            RENTBEMESSUNGSGR_OST = RENTBEMESSUNGSGR_OST_2019;
            KORREKTURFAKTOR_VSP = KORREKTURFAKTOR_VSP_2019;
            KV_GRENZ = KV_GRENZ_2019;
            RENTENVERS_SATZ_AN = RENTENVERS_SATZ_AN_ab2019;
            KV_SATZ_AG = KV_SATZ_AG_2019;
            KV_SATZ_AN = KV_SATZ_AN_2019;
            PV_SATZ_AG = PV_SATZ_AG_2019;
            PV_SATZ_AN = PV_SATZ_AN_2019;
            RENT_SATZ = RENT_SATZ_2019;
            KINDERFREIBETRAG = KINDERFREIBETRAG_2019;
            ALLEINERZ_FREIBETRAG = ALLEINERZ_FREIBETRAG_ab2019;
            GRENZW1_STKL5 = GRENZW1_STKL5_2019;
            GRENZW2_STKL5 = GRENZW2_STKL5_2019;
            GRENZW3_STKL5 = GRENZW3_STKL5_2019;
            GRUNDFREIBETRAG = GRUNDFREIBETRAG_2019;
            break;
        }
		
		//standardsatz kirchensteuer:
		kirchensteuersatz = 0.09;
		
		//setze OST/WEST/Sachsen flag/BW&BAY-Kirchensatz
		if( bundesland.matches("سكسونيا السفلى") |
				bundesland .matches("بافاريا")|
				bundesland .matches("سارلاند")  |
				bundesland .matches("شمال الراين-وستفاليا ") |
				bundesland .matches("هامبورغ") |
				bundesland .matches("بريمن")  |
				bundesland.matches("هسن ")|
				bundesland .matches("راينلند-بالاتينات ")|
				bundesland .matches("بادن-فورتمبيرغ ") |
				bundesland .matches("بافاريا")  )
		{
			istWestAN = true;
			istSachsenAN = false;
			
			if( bundesland .matches("بافاريا")  |
					bundesland .matches("بادن-فورتمبيرغ")	)
			{
				//satz f�r BAY/BW
				kirchensteuersatz =  0.08;
			}
		}
		else
		{
			istWestAN = false;
			if( bundesland .matches("ساكسونيا-أنهالت" ))
			{
				istSachsenAN = true;
			}
			else
			{
				istSachsenAN = false;
			}
		}
		
		//Zeitraum
	    /*		
	    1 = Jahr
	    2 = Monat
	    3 = Woche
	    4 = Tag*/

			if (zeitraum.matches("JAHR") ){

				LZZ = 1;

				zeitraumteiler = 1;

			}
		if (zeitraum.matches("MONAT")) {
			LZZ = 2;
			zeitraumteiler = 12;

		}
		if(zeitraum.matches("WOCHE") ){
			LZZ = 3;
			zeitraumteiler = 360 * 7;
		}
		if(zeitraum=="TAG") {
			LZZ = 4;
			zeitraumteiler = 360;

		}


	}
	
	public void berechnen( int steuerklasse, double lohn, boolean pkv, boolean pkv_zuschuss,double b, boolean rentenversichert, boolean arbeitsversichert, boolean kirche, boolean kinder, double kinderfreibetraege, boolean faktorverfahren, double faktor, boolean arbeitskammer, double bav, double bav_ag, double vwl, double vwl_ag, double gwv, int jahrgang, double freibetrag, double hinzurechnungsbetrag, double gkv_zusatzbeitrag )
	{
		STKL = steuerklasse;

		
		if( ( faktorverfahren ) && ( steuerklasse == 4 ) )
		{
			af = 1;
			f = faktor; 
		}
		else
		{
			af = 0;
			f = 1;
		}
		
		
		//berechne brutto
		brutto = lohn - bav + bav_ag + vwl_ag + gwv ;
		RE4 = brutto*100;
		
		
		//Alter
		ALTER1 = 0;
		AJAHR = 0;
		if( jahrgang > 0 )
		{
			alter = AKTUELLES_JAHR - jahrgang;
			if ( alter >= 65 )
			{
				//1, wenn das 64. Lebensjahr zu Beginn des Kalenderjahres vollendet wurde, in dem der Lohnzahlungszeitraum endet (� 24 a EStG), sonst = 0 */
				ALTER1 = 1;			
				//Auf die Vollendung des 64. Lebensjahres folgende Kalenderjahr (erforderlich, wenn ALTER1=1)
				AJAHR = AKTUELLES_JAHR + ( alter - 65) ;
			}
		}
		else
		{
			//Annahme mittleres Alter - d.h. ggf. Zuschlag zur Pflegeversicherung und keine Altersentlastung			
			alter = 30;
		}
		
		
		/*Merker f�r die Vorsorgepauschale
		2 = der Arbeitnehmer ist NICHT in der gesetzlichen Rentenversicherung versichert.
				
		1 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die 
			Beitragsbemessungsgrenze OST.
					
		0 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die 
			Beitragsbemessungsgrenze WEST.*/
		if( rentenversichert )
		{
			if( istWestAN )
			{
				KRV = 0;
			}
			else
			{
				KRV = 1;
			}
		}
		else
		{
			KRV = 2;
		}
		
		//set Kirchensteuer f�r Einkommenssteuerberechnung
		if ( kirche )
		{
			R = 1;
		}
		else
		{
			R = 0;
		}
		//kinderfreibetr�ge und pflegezuschlag verarbeiten
		if( kinder )
		{
			PVZ = 0;
			ZKF = kinderfreibetraege;
		}
		else
		{
			
			if( alter > 22 ) // && ( alter < 74 ) 
			{
				//Aufschlag f�r Kinderlose (nur wenn 23. Lebensjahr vollendet) nicht ber�cksichtigt - checken: und nach dem 31. Dezember 1939 geboren
				PVZ = 1; //bei kinderlosigkeit
			}
			else
			{
				//j�nger als 23!
				PVZ = 0;
			}
			
			ZKF = 0; //kein Kinderfreibetrag
		}
		
		
		/*Krankenversicherung:
        0 = gesetzlich krankenversicherte Arbeitnehmer
        1 = ausschlie�lich privat krankenversicherte Arbeitnehmer OHNE Arbeitgeberzuschuss
        2 = ausschlie�lich privat krankenversicherte Arbeitnehmer MIT Arbeitgeberzuschuss*/
		if( pkv )
		{
			PKPV = b *100;
			if( pkv_zuschuss )
			{
				PKV = 2;

			}
			else
			{
				PKV = 1;
			}
		}
		else
		{
			PKV = 0;	//GKV
		}
		
		//Frei- und Hinzurechnungsbetrag ber�cksichtigen
		JFREIB = freibetrag * 100; //bei MSONST!
		LZZFREIB = freibetrag * 100 / zeitraumteiler;
		JHINZU = hinzurechnungsbetrag * 100; //bei MSONST!
		LZZHINZU = hinzurechnungsbetrag *100 / zeitraumteiler;
		
		//todo versorgungsbez�ge JVBEZ
		
		/*Hier werden vor der Berechnung die Jahresabh�ngigen Parameter bzw. lokalen (Ost/West) Paramter f�r die Berechnung gesetzt
		vergleiche neue Funktion vom BMF ab 2015 MPARA -> da vorher schon selber eingef�hrt (s.o.) tlw �berfl�ssige Parameter�bergabe Refactoring sinnvoll...*/
		if( KRV < 2 )
		{
			if( istWestAN )
			{
				BBGRV = RENTBEMESSUNGSGR_WEST;
			}
			else
			{
				BBGRV = RENTBEMESSUNGSGR_OST;
			}
			RVSATZAN = RENTENVERS_SATZ_AN;
			TBSVORV = KORREKTURFAKTOR_VSP;
		}
       	BBGKVPV = KV_GRENZ;
       	
		//Ab Steuerjahr 2019 wird der Zusatzbeitrag wieder geteilt!
		//switch damit bei neuem Steuerjahr an Check gedacht wird...
		switch ( AKTUELLES_JAHR )
		{
		case 2013:
  		case 2014:
  		case 2015:
		case 2016:
		case 2017:
		case 2018:
			KVSATZAN = ( KV_SATZ_AN + gkv_zusatzbeitrag ) / 100;
			KVSATZAG = KV_SATZ_AG / 100;
  		break;		
		case 2019:
			KVSATZAN = ( KV_SATZ_AN + ( gkv_zusatzbeitrag ) / 2 ) / 100;
			KVSATZAG = ( KV_SATZ_AG + ( gkv_zusatzbeitrag ) / 2 ) / 100;
  		break;
		}

       	
		//Sonderregelung in Sachsen
      	if( istSachsenAN )
		{
			PVSATZAN = ( PV_SATZ_AN + 0.5 ) / 100;	//Besonderheit in Sachsen
			PVSATZAG = ( PV_SATZ_AG - 0.5 ) / 100;
		}
		else
		{
			PVSATZAN = PV_SATZ_AN / 100;
			PVSATZAG = PV_SATZ_AG / 100;
		}
		
		//Beitragszuschlag f�r Kinderlose
		if ( PVZ == 1 )
		{
			PVSATZAN = PVSATZAN + 0.0025;
		}

        //setze Grundfreibetrag
        GFB = GRUNDFREIBETRAG;

      	//Ende "MPARA"

		//start calculation due tom BMF
		switch ( AKTUELLES_JAHR )
		{
		case 2013:
  		case 2014:
  		case 2015:
  			calculateSteuer2013();
		break;
		case 2016:
		case 2017:
		case 2018:
			///////Hallo wir brauchen ein Aufbaue der Funktion ! 
		case 2019:
  			calculateSteuer2016(); //ab 2016 neue Main Routine (minimale �nderungen)
  		break;
		}
		
		//start Berechnung Sozialabgaben
		if( rentenversichert ) rentenversicherung = berechneRentenversicherung();
		if( !pkv ) krankenversicherung = berechneKrankensicherung();
		if( arbeitsversichert ) arbeitslosenversicherung = berechneArbeitslosenversicherung();
		if( !pkv ) pflegeversicherung = berechnePflegeversicherung();
		
		//Berechnung Arbeitskammer (Bremen, Saarland)
		if( arbeitskammer ) arbeitskammerbeitrag = berechneArbeitskammerbeitrag();

		
		//umrechnung auf Zielzeit
		rentenversicherung = rentenversicherung / zeitraumteiler;
		krankenversicherung = krankenversicherung / zeitraumteiler;
		arbeitslosenversicherung = arbeitslosenversicherung / zeitraumteiler;
		pflegeversicherung = pflegeversicherung / zeitraumteiler;
		arbeitskammerbeitrag = arbeitskammerbeitrag / zeitraumteiler;
			
		
		//calculate Kirchensteuer
		if( kirche )
		{
			kirchensteuer = berechneKirchensteuer();
		}
		
		//calculate netto and "auszahlungsbetrag"
		netto = getBrutto() - getArbeitslosenversicherung() - getPflegeversicherung() - getRentenversicherung() - getKrankenversicherung() - getKirchensteuer() - getSoli() - getLohnsteuer() - getArbeitskammerbeitrag();
		auszahlung = getNetto() - vwl - gwv;
	}
	
	public double getBrutto()
	{
		return brutto;
	}
	
	public double getLohnsteuer()
	{
		return abrundenCent( LSTLZZ / 100 );
	}
	
	public double getSoli()
	{
		return abrundenCent( SOLZLZZ / 100 );
	}
	
	public double getKirchensteuer()
	{
		return abrundenCent( kirchensteuer / 100 );
	}
	
	public double getKrankenversicherung()
	{
		return  rundenCent( krankenversicherung );
	}
	
	public double getRentenversicherung()
	{
		return rundenCent( rentenversicherung / 100 );
	}
	
	public double getPflegeversicherung()
	{
		return rundenCent( pflegeversicherung / 100 );
	}
	
	public double getArbeitslosenversicherung()
	{
		return rundenCent( arbeitslosenversicherung / 100 );
	}	
	
	public double getArbeitskammerbeitrag()
	{
		return rundenCent( arbeitskammerbeitrag );
	}
	
	public double getNetto()
	{
		return rundenCent( netto );
	}
	
	public double getAuszahlung()
	{
		return rundenCent( auszahlung );
	}	
	
	public double getZuVersteuerndesEinkommen()
	{
		return rundenCent( ZVE / zeitraumteiler );
	}


	//Berechnungen & Checks
	public boolean isBavValid( double bav, String bundesland )
	{		
		//Unter bestimmten Voraussetzungen erh�ht sich dieser Betrag noch um 1.800 �. � 40b EStG erm�glicht die Pauschalierung der Lohnsteuer bei Pensionskassenzusagen, im Rahmen der �bergangsregelung zur alten Fassung auch noch bei Direktversicherungen. 
		if( istWestAN )
		{
			return ( bav <= ( ( 0.04 * RENTBEMESSUNGSGR_WEST + 1800 ) / zeitraumteiler ) );
		}
		else
		{
			return ( bav <= ( ( 0.04 * RENTBEMESSUNGSGR_OST + 1800 ) / zeitraumteiler ) );
		}
	}	
	
	private double berechneKirchensteuer()
	{		
		return rundenCent( BK * kirchensteuersatz );
	}
		
	private double berechneRentenversicherung()
	{
		double grenze, beitrag;
		
		if( istWestAN )
		{
			grenze = RENTBEMESSUNGSGR_WEST;
		}
		else
		{
			grenze = RENTBEMESSUNGSGR_OST;	
		}
		if ( ZRE4J > grenze )
		{
			beitrag = grenze;
		}
		else
		{
			beitrag = ZRE4J;
		}
		
		beitrag = beitrag * RENT_SATZ / 2;
		
		return beitrag;
	}
	
	private double berechneArbeitslosenversicherung()
	{
		double grenze, beitrag;
		
		if( istWestAN )
		{
			grenze = RENTBEMESSUNGSGR_WEST;
		}
		else
		{
			grenze = RENTBEMESSUNGSGR_OST;	
		}
		if ( ZRE4J > grenze )
		{
			beitrag = grenze;
		}
		else
		{
			beitrag = ZRE4J;
		}
		
		beitrag = beitrag * ARB_SATZ / 2;
		
		return beitrag;
	}	
	
	
	private double berechnePflegeversicherung()
	{
		double satz, beitrag;
		
		if ( ZRE4J > KV_GRENZ )
		{
			beitrag = KV_GRENZ;
		}
		else
		{
			beitrag = ZRE4J;
		}
		satz = PV_SATZ_AN;
		
		if( istSachsenAN )
		{
			//andere aufteilung in Sachsen
			satz = satz + 0.5;
		}
		
		if( PVZ == 1 )
		{
			satz = satz + 0.25;
		}

		beitrag = beitrag * satz;
		
		return beitrag;
	}
	
	
	private double berechneKrankensicherung()
	{
		double beitrag;
		
		if ( ZRE4J > KV_GRENZ )
		{
			beitrag = KV_GRENZ;
		}
		else
		{
			beitrag = ZRE4J;
		}
		
		beitrag = beitrag * ( KVSATZAN + 0.003 ); //KVSATZAN beinhaltet gesetzlichen Beitragssatz + Zusatzbeitragssatz / 100
		
		return beitrag;
	}
	
	
	private double berechneArbeitskammerbeitrag()
	{
		double beitrag = ZRE4J;
		
		//Arbeitskammerzuschlag von 0,15% in Bremen / Saarland
		if ( beitrag > ( 0.75 * RENTBEMESSUNGSGR_WEST ) )
		{
			beitrag = 0.75 * RENTBEMESSUNGSGR_WEST;
		}
		return ( beitrag * 0.15 / 100 );
	}
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	//********************************************************
	//Berechnung laut BMF (https://www.bmf-steuerrechner.de)
	//Basiskonvertierung: 2012-09-20, 18:25
	//Funktionsstand :	  2015-01-03
	//
	//https://www.bmf-steuerrechner.de/interface/
	//********************************************************
	
	
	//Eingabeparameter
    // 1, wenn die Anwendung des Faktorverfahrens gew�hlt wurden (nur in Steuerklasse IV)
    private double af = 0;

    //Auf die Vollendung des 64. Lebensjahres folgende Kalenderjahr (erforderlich, wenn ALTER1=1)
    private int AJAHR = 0;

    //1, wenn das 64. Lebensjahr zu Beginn des Kalenderjahres vollendet wurde, in dem der Lohnzahlungszeitraum endet (� 24 a EStG), sonst = 0 */
    private double ALTER1 = 0;

    //in VKAPA und VMT enthaltene Entsch�digungen nach �24 Nummer 1 EStG in Cent
    private double ENTSCH = 0;

    //eingetragener Faktor mit drei Nachkommastellen 
    private double f = 1.0;

    //Jahresfreibetrag nach Ma�gabe der Eintragungen auf der Lohnsteuerkarte in Cents (ggf. 0) */
    private double JFREIB = 0;

    //Jahreshinzurechnungsbetrag in Cents (ggf. 0)
    private double JHINZU = 0;

    /*Voraussichtlicher Jahresarbeitslohn ohne sonstige Bez�ge und ohne Verg�tung f�r mehrj�hrige T�tigkeit in Cent. 
    Anmerkung: Die Eingabe dieses Feldes (ggf. 0) ist erforderlich bei Eingabe �sonsti-ger Bez�ge� (Feld SONSTB) 
    oder bei Eingabe der �Verg�tung f�r mehrj�hrige T�tigkeit� (Feld VMT).
    Sind in einem vorangegangenen Abrechnungszeitraum bereits sonstige Bez�ge gezahlt worden, so sind sie dem 
    voraussichtlichen Jahresarbeitslohn hinzuzurechnen. Verg�tungen f�r mehrere Jahres aus einem vorangegangenen 
    Abrechnungszeitraum sind in voller H�he hinzuzurechnen.*/ 
    private double JRE4 = 0;
 
    //In JRE4 enthaltene Versorgungsbezuege in Cents (ggf. 0)
    private double JVBEZ = 0;

	/*Merker f�r die Vorsorgepauschale
	2 = der Arbeitnehmer ist NICHT in der gesetzlichen Rentenversicherung versichert.
			
	1 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die 
		Beitragsbemessungsgrenze OST.
				
	0 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die 
		Beitragsbemessungsgrenze WEST.*/
    private double KRV = 0;

	/*Einkommensbezogener Zusatzbeitragssatz eines gesetzlich krankenversicherten Arbeitnehmers, 
	 auf dessen Basis der an die Kran-kenkasse zu zahlende Zusatzbeitrag berechnet wird,
	 in Prozent (bspw. 0,90 f�r 0,90 %) mit 2 Dezimalstellen. 
	 Der von der Kranken-kasse festgesetzte Zusatzbeitragssatz ist bei Abweichungen unma�geblich.*/
	//private double KVZ = 0;
	
    /*Lohnzahlungszeitraum:
    1 = Jahr
    2 = Monat
    3 = Woche
    4 = Tag*/
    private int LZZ = 0;

    //In der Lohnsteuerkarte des Arbeitnehmers eingetragener Freibetrag f�r den Lohnzahlungszeitraum in Cent */
    private double LZZFREIB = 0;

    //In der Lohnsteuerkarte des Arbeitnehmers eingetragener Hinzurechnungsbetrag f�r den Lohnzahlungszeitraum in Cent */
    private double LZZHINZU = 0;

    /*Dem Arbeitgeber mitgeteilte Zahlungen des Arbeitnehmers zur privaten
     Kranken- bzw. Pflegeversicherung im Sinne des �10 Abs. 1 Nr. 3 EStG 2010
     als Monatsbetrag in Cent (der Wert ist inabh�ngig vom Lohnzahlungszeitraum immer 
     als Monatsbetrag anzugeben).*/
    private double PKPV = 0;
        
    /*Krankenversicherung:
         0 = gesetzlich krankenversicherte Arbeitnehmer
         1 = ausschlie�lich privat krankenversicherte Arbeitnehmer OHNE Arbeitgeberzuschuss
         2 = ausschlie�lich privat krankenversicherte Arbeitnehmer MIT Arbeitgeberzuschuss*/
    private double PKV = 0;
    
    //1, wenn bei der sozialen Pflegeversicherung die Besonderheiten in Sachsen zu ber�cksichtigen sind bzw. zu ber�cksichtigen w�ren, sonst 0.
   // private double PVS = 0;

    //1, wenn er der Arbeitnehmer den Zuschlag zur sozialen Pflegeversicherung zu zahlen hat, sonst 0. */
    private double PVZ = 0;
    
    //Religionsgemeinschaft des Arbeitnehmers lt. Lohnsteuerkarte (bei keiner Religionszugehoerigkeit = 0)
    private double R = 0;

    /*Steuerpflichtiger Arbeitslohn vor Beruecksichtigung der Freibetraege
         fuer Versorgungsbezuege, des Altersentlastungsbetrags und des auf
         der Lohnsteuerkarte fuer den Lohnzahlungszeitraum eingetragenen
         Freibetrags in Cents.*/
    private double RE4 = 0;

    /*Sonstige Bezuege (ohne Verguetung aus mehrjaehriger Taetigkeit) einschliesslich
         Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen,
         soweit es sich nicht um Bezuege fuer mehrere Jahre handelt in Cents (ggf. 0)*/
    private double SONSTB = 0;

    /*Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen,
         soweit es sich nicht um Bezuege fuer mehrere Jahre handelt
         (in SONSTB enthalten) in Cents*/
    private double STERBE = 0; // regex_test="" regex_transform=""

    /*Steuerklasse:
         1 = I
         2 = II
         3 = III
         4 = IV
         5 = V
         6 = VI*/
    private int STKL;

    //In RE4 enthaltene Versorgungsbezuege in Cents (ggf. 0)
    private double VBEZ = 0;

    //Vorsorgungsbezug im Januar 2005 bzw. fuer den ersten vollen Monat in Cents
    private double VBEZM = 0;

    /*Voraussichtliche Sonderzahlungen im Kalenderjahr des Versorgungsbeginns
         bei Versorgungsempfaengern ohne Sterbegeld, Kapitalauszahlungen/Abfindungen
         bei Versorgungsbezuegen in Cents*/
    private double VBEZS = 0;

    /* In SONSTB enthaltene Versorgungsbezuege einschliesslich Sterbegeld
        in Cents (ggf. 0) */
    private double VBS = 0;

    /* Jahr, in dem der Versorgungsbezug erstmalig gewaehrt wurde; werden
         mehrere Versorgungsbezuege gezahlt, so gilt der aelteste erstmalige Bezug */
    private int VJAHR;  // regex_test="" regex_transform=""/>

    /* Kapitalauszahlungen / Abfindungen / Nachzahlungen bei Versorgungsbez�gen 
         f�r mehrere Jahre in Cent (ggf. 0) */     
    private double VKAPA = 0;  // regex_test="" regex_transform=""/>
 
	/* Verg�tung f�r mehrj�hrige T�tigkeit ohne Kapitalauszahlungen und ohne Abfindungen 
		 bei Versorgungsbez�gen in Cent (ggf. 0) */
    private double VMT = 0;  // regex_test="" regex_transform=""/>

    /* Zahl der Freibetraege fuer Kinder (eine Dezimalstelle, nur bei Steuerklassen
         I, II, III und IV) */
    private double ZKF;  // regex_test="" regex_transform=""/>

    /* Zahl der Monate, fuer die Versorgungsbezuege gezahlt werden (nur
         erforderlich bei Jahresberechnung (LZZ = 1) */
    private double ZMVB = 12;   // regex_test="" regex_transform=""/>
    
    /* In JRE4 enthaltene Entsch�digungen nach � 24 Nummer 1 EStG in Cent */
    private double JRE4ENT = 0;  // default="BigDecimal.ZERO"/>
	
	/* In SONSTB enthaltene Entsch�digungen nach � 24 Nummer 1 EStG in Cent */
    private double SONSTENT = 0; // default="BigDecimal.ZERO"/>

    
    
    
/*  AUSGABEPARAMETER  */

    /* Bemessungsgrundlage fuer die Kirchenlohnsteuer in Cents */
    private double BK = 0;   

    /* Bemessungsgrundlage der sonstigen Einkuenfte (ohne Verguetung
         fuer mehrjaehrige Taetigkeit) fuer die Kirchenlohnsteuer in Cents */
    private double BKS = 0;

    private double BKV = 0;

    /* Fuer den Lohnzahlungszeitraum einzubehaltende Lohnsteuer in Cents */
    private double LSTLZZ = 0;

    /* Fuer den Lohnzahlungszeitraum einzubehaltender Solidaritaetszuschlag
         in Cents */
    private double SOLZLZZ = 0;

    /* Solidaritaetszuschlag fuer sonstige Bezuege (ohne Verguetung fuer mehrjaehrige
         Taetigkeit) in Cents */
    private double SOLZS = 0;

    /* Solidaritaetszuschlag fuer die Verguetung fuer mehrjaehrige Taetigkeit in
         Cents */
    private double SOLZV = 0;

    /* Lohnsteuer fuer sonstige Einkuenfte (ohne Verguetung fuer mehrjaehrige
         Taetigkeit) in Cents */
    private double STS = 0;

    /* Lohnsteuer fuer Verguetung fuer mehrjaehrige Taetigkeit in Cents */
    private double STV = 0;


/*  INTERNE FELDER  */
 
	//Ausgabeparameter f�r Doppelbesteuerungsabkommen (DBA) mit der T�rkei, wird von der App nicht unterst�tzt, lediglich Outputparameter (werden nicht weiterverwendet!)
    	//Verbrauchter Freibetrag bei Berechnung des laufenden Arbeitslohns, in Cent
    	//private double VFRB = 0;
		
		//Verbrauchter Freibetrag bei Berechnung des voraussichtlichen Jahresarbeitslohns, in Cent 
    	//private double VFRBS1 = 0;
		
		//Verbrauchter Freibetrag bei Berechnung der sonstigen Bez�ge, in Cent 
    	//private double VFRBS2 = 0;
		
		//F�r die weitergehende Ber�cksichtigung des Steuerfreibetrags nach dem DBA T�rkei verf�gbares ZVE �ber 
	    //dem Grundfreibetrag bei der Berechnung des laufenden Arbeitslohns, in Cent 
    	//private double WVFRB = 0;
		
		//F�r die weitergehende Ber�cksichtigung des Steuerfreibetrags nach dem DBA T�rkei verf�gbares ZVE �ber dem Grundfreibetrag 
		//bei der Berechnung des voraussichtlichen Jahresarbeitslohns, in Cent 
    	//private double WVFRBO = 0;
		
		//F�r die weitergehende Ber�cksichtigung des Steuerfreibetrags nach dem DBA T�rkei verf�gbares ZVE 
		//�ber dem Grundfreibetrag bei der Berechnung der sonstigen Bez�ge, in Cent -->
    	//private double WVFRBM = 0;
	//Ende DBA Ausgabeparameter
    
	/* spezielles ZVE f. Einkommensteuer-Berechnung, dieses darf negativ werden. */
    //private double zveEkSt = 0;
	
    //private double zveGemeinsam = 0;

    /* Altersentlastungsbetrag nach Alterseink�nftegesetz in �,
         Cent (2 Dezimalstellen) */
    private double ALTE = 0;

    /* Arbeitnehmer-Pauschbetrag in EURO */
    private double ANP = 0;

    /* Auf den Lohnzahlungszeitraum entfallender Anteil von Jahreswerten
         auf ganze Cents abgerundet */
    private double ANTEIL1 = 0;

    /* Bemessungsgrundlage f�r Altersentlastungsbetrag in �, Cent
         (2 Dezimalstellen) */
    private double BMG = 0;
    
    /*Beitragsbemessungsgrenze in der gesetzlichen Krankenversicherung 
    	und der sozialen Pflegeversicherung in Euro*/
    private double BBGKVPV = 0;
    
    /*allgemeine Beitragsbemessungsgrenze in der allgemeinen Renten-versicherung in Euro*/
    private double BBGRV = 0;
    
    /* Differenz zwischen ST1 und ST2 in EURO */
    private double DIFF = 0;

    /* Entlastungsbetrag fuer Alleinerziehende in EURO */
    private double EFA = 0;

    /* Versorgungsfreibetrag in �, Cent (2 Dezimalstellen) */
    private double FVB = 0;

    /* Versorgungsfreibetrag in �, Cent (2 Dezimalstellen) f�r die Berechnung
         der Lohnsteuer f�r den sonstigen Bezug */
    private double FVBSO = 0;

    /* Zuschlag zum Versorgungsfreibetrag in EURO */
    private double FVBZ = 0;

    /* Zuschlag zum Versorgungsfreibetrag in EURO fuer die Berechnung
         der Lohnsteuer beim sonstigen Bezug */
    private double FVBZSO = 0;
    
 	/*Grundfreibetrag in Euro*/
    private double GFB = 0;  //ab 2016 eingef�hrt
 
    /* Maximaler Altersentlastungsbetrag in � */
    private double HBALTE = 0;

    /* Massgeblicher maximaler Versorgungsfreibetrag in � */
    private double HFVB = 0;

    /* Massgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in �,Cent
         (2 Dezimalstellen) */
    private double HFVBZ = 0;

    /* Massgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in �, Cent
         (2 Dezimalstellen) f�r die Berechnung der Lohnsteuer f�r den
         sonstigen Bezug */
    private double HFVBZSO = 0;
	
     /* Nummer der Tabellenwerte fuer Versorgungsparameter */
    private int J = 0;

    /* Jahressteuer nach � 51a EStG, aus der Solidaritaetszuschlag und
         Bemessungsgrundlage fuer die Kirchenlohnsteuer ermittelt werden in EURO */
    private double JBMG = 0;

    /* Auf einen Jahreslohn hochgerechneter LZZFREIB in �, Cent
         (2 Dezimalstellen) */
    private double JLFREIB = 0;

    /* Auf einen Jahreslohn hochgerechnete LZZHINZU in �, Cent
         (2 Dezimalstellen) */
    private double JLHINZU = 0;

    /* Jahreswert, dessen Anteil fuer einen Lohnzahlungszeitraum in
         UPANTEIL errechnet werden soll in Cents */
    private double JW = 0;

    /* Nummer der Tabellenwerte fuer Parameter bei Altersentlastungsbetrag */
    private int K = 0;

    /* Merker f�r Berechnung Lohnsteuer f�r mehrj�hrige T�tigkeit.
		 0 = normale Steuerberechnung
		 1 = Steuerberechnung f�r mehrj�hrige T�tigkeit
		 2 = entf�llt */     
    private double KENNVMT = 0;
 
        /* Summe der Freibetraege fuer Kinder in EURO */
    private double KFB = 0;

    /* Beitragssatz des Arbeitgebers zur Krankenversicherung */
    private double KVSATZAG = 0;

    /* Beitragssatz des Arbeitnehmers zur Krankenversicherung */
    private double KVSATZAN = 0;

   /* Kennzahl fuer die Einkommensteuer-Tabellenart:
         1 = Grundtabelle
         2 = Splittingtabelle */
    private double KZTAB = 0;

    /* Jahreslohnsteuer in EURO */
    private double LSTJAHR = 0;

    /* Zwischenfelder der Jahreslohnsteuer in Cent */
    private double LST1 = 0;
    private double LST2 = 0;
    private double LST3 = 0;
    private double LSTOSO = 0;
    private double LSTSO = 0;

    /* Mindeststeuer fuer die Steuerklassen V und VI in EURO */
    private double MIST = 0;

    /* Beitragssatz des Arbeitgebers zur Pflegeversicherung */
    private double PVSATZAG = 0;

    /* Beitragssatz des Arbeitnehmers zur Pflegeversicherung */
    private double PVSATZAN = 0;

    /*Beitragssatz des Arbeitnehmers in der allgemeinen gesetzlichen Rentenversicherung (4 Dezimalstellen) */
    private double RVSATZAN = 0;
    
    /* Rechenwert in Gleitkommadarstellung */
    private double RW = 0;

    /* Sonderausgaben-Pauschbetrag in EURO */
    private double SAP = 0;

    /* Freigrenze fuer den Solidaritaetszuschlag in EURO */
    private double SOLZFREI = 0;

    /* Solidaritaetszuschlag auf die Jahreslohnsteuer in EURO, C (2 Dezimalstellen) */
    private double SOLZJ = 0;

    /* Zwischenwert fuer den Solidaritaetszuschlag auf die Jahreslohnsteuer
         in EURO, C (2 Dezimalstellen) */
    private double SOLZMIN = 0;

    /* Tarifliche Einkommensteuer in EURO */
    private double ST = 0;

    /* Tarifliche Einkommensteuer auf das 1,25-fache ZX in EURO */
    private double ST1 = 0;

    /* Tarifliche Einkommensteuer auf das 0,75-fache ZX in EURO */
    private double ST2 = 0;
 
	/* Zwischenfeld zur Ermittlung der Steuer auf Verg�tungen f�r mehrj�hrige T�tigkeit */
    private double STOVMT = 0;
    
    /*Teilbetragssatz der Vorsorgepauschale f�r die Rentenversicherung (2 Dezimalstellen)*/
    private double TBSVORV = 0;
    
    /* Bemessungsgrundlage fuer den Versorgungsfreibetrag in Cents */
    private double VBEZB = 0;

    /* Bemessungsgrundlage f�r den Versorgungsfreibetrag in Cent f�r
         den sonstigen Bezug */
    private double VBEZBSO = 0;

    /* Hoechstbetrag der Vorsorgepauschale nach Alterseinkuenftegesetz in EURO, C */
    private double VHB = 0;

    /* Vorsorgepauschale in EURO, C (2 Dezimalstellen) */
    private double VSP = 0;

    /* Vorsorgepauschale nach Alterseinkuenftegesetz in EURO, C */
    private double VSPN = 0;

    /* Zwischenwert 1 bei der Berechnung der Vorsorgepauschale nach
         dem Alterseinkuenftegesetz in EURO, C (2 Dezimalstellen) */
    private double VSP1 = 0;

    /* Zwischenwert 2 bei der Berechnung der Vorsorgepauschale nach
         dem Alterseinkuenftegesetz in EURO, C (2 Dezimalstellen) */
    private double VSP2 = 0;
	
	/* Vorsorgepauschale mit Teilbetr�gen f�r die gesetzliche Kranken- und 
		 soziale Pflegeversicherung nach fiktiven Betr�gen oder ggf. f�r die
		 private Basiskrankenversicherung und private Pflege-Pflichtversicherung 
		 in Euro, Cent (2 Dezimalstellen) */
    private double VSP3 = 0;

    /* Erster Grenzwert in Steuerklasse V/VI in Euro */
    //private double W1STKL5 = 0; entspricht GRENZW1_STKL5
    
    /* Zweiter Grenzwert in Steuerklasse V/VI in Euro */
    //private double W2STKL5 = 0; entspricht GRENZW2_STKL5
    
    /* Dritter Grenzwert in Steuerklasse V/VI in Euro */
    //private double W3STKL5 = 0; entspricht GRENZW3_STKL5
    
    /* Hoechstbetrag der Vorsorgepauschale nach � 10c Abs. 3 EStG in EURO */
    //private double VSPKURZ = 0;

    /* Hoechstbetrag der Vorsorgepauschale nach � 10c Abs. 2 Nr. 2 EStG in EURO */
    //private double VSPMAX1 = 0;

    /* Hoechstbetrag der Vorsorgepauschale nach � 10c Abs. 2 Nr. 3 EStG in EURO */
    //private double VSPMAX2 = 0;

    /* Vorsorgepauschale nach � 10c Abs. 2 Satz 2 EStG vor der Hoechstbetragsberechnung
         in EURO, C (2 Dezimalstellen) */
    //private double VSPO = 0;

    /* Fuer den Abzug nach � 10c Abs. 2 Nrn. 2 und 3 EStG verbleibender
         Rest von VSPO in EURO, C (2 Dezimalstellen) */
    //private double VSPREST = 0;

    /* Hoechstbetrag der Vorsorgepauschale nach � 10c Abs. 2 Nr. 1 EStG
         in EURO, C (2 Dezimalstellen) */
    //private double VSPVOR = 0;

    /* Zu versteuerndes Einkommen gem. � 32a Abs. 1 und 2 EStG �, C
         (2 Dezimalstellen) */
    private double X = 0;

    /* gem. � 32a Abs. 1 EStG (6 Dezimalstellen) */
    private double Y = 0;

    /* Auf einen Jahreslohn hochgerechnetes RE4 in �, C (2 Dezimalstellen)
         nach Abzug der Freibetr�ge nach � 39 b Abs. 2 Satz 3 und 4. */
    private double ZRE4 = 0;

    /* Auf einen Jahreslohn hochgerechnetes RE4 in �, C (2 Dezimalstellen) */
    private double ZRE4J = 0;

    /* Auf einen Jahreslohn hochgerechnetes RE4 in �, C (2 Dezimalstellen)
         nach Abzug des Versorgungsfreibetrags und des Alterentlastungsbetrags
         zur Berechnung der Vorsorgepauschale in �, Cent (2 Dezimalstellen) */
    private double ZRE4VP = 0;

    /* Feste Tabellenfreibetr�ge (ohne Vorsorgepauschale) in �, Cent
         (2 Dezimalstellen) */
    private double ZTABFB = 0;

    /* Auf einen Jahreslohn hochgerechnetes (VBEZ abzueglich FVB) in
         EURO, C (2 Dezimalstellen) */
    private double ZVBEZ = 0;

    /* Auf einen Jahreslohn hochgerechnetes VBEZ in �, C (2 Dezimalstellen) */
    private double ZVBEZJ = 0;

    /* Zu versteuerndes Einkommen in �, C (2 Dezimalstellen) */
    private double ZVE = 0;
    
    /* Zwischenfelder zu X fuer die Berechnung der Steuer nach � 39b
         Abs. 2 Satz 7 EStG in � */
    private double ZX = 0;
    private double ZZX = 0;
    private double HOCH = 0;
    private double VERGL = 0;
	
	 /* Jahreswert der ber�cksichtigten Beitr�ge zur privaten Basis-Krankenversicherung und 
		  privaten Pflege-Pflichtversicherung (ggf. auch die Mindestvorsorgepauschale) in Cent. */
    private double VKV = 0;
	
	/* F�r den Lohnzahlungszeitraum ber�cksichtigte Beitr�ge des Arbeitnehmers zur
		 privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf. auch
		 die Mindestvorsorgepauschale) in Cent beim laufenden Arbeitslohn. F�r Zwecke der Lohn-
		 steuerbescheinigung sind die einzelnen Ausgabewerte au�erhalb des eigentlichen Lohn-
		 steuerbescheinigungsprogramms zu addieren; hinzuzurechnen sind auch die Ausgabewerte
		 VKVSONST */
    private double VKVLZZ = 0;
	
	/* F�r den Lohnzahlungszeitraum ber�cksichtigte Beitr�ge des Arbeitnehmers 
		 zur privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf. 
		 auch die Mindestvorsorgepauschale) in Cent bei sonstigen Bez�gen. Der Ausgabewert kann
		 auch negativ sein. F�r tariferm��igt zu besteuernde Verg�tungen f�r mehrj�hrige 
		 T�tigkeiten enth�lt der PAP keinen entsprechenden Ausgabewert. */
	private double VKVSONST = 0;


	//KONSTANTEN
	
    /* Tabelle fuer die Vomhundertsaetze des Versorgungsfreibetrags */
    private final static double TAB1[] = {0.0, 0.4, 0.384, 0.368, 0.3, 0.336, 0.32, 0.304, 0.288, 0.272, 0.256, 0.24, 0.224, 0.208, 0.192, 0.176, 0.16, 0.152, 0.144, 0.136, 0.128, 0.12, 0.112, 0.104, 0.096, 0.088, 0.08, 0.072, 0.064, 0.056, 0.048, 0.04, 0.032, 0.024, 0.016, 0.008, 0.0};

    /* Tabelle fuer die Hoechstbetrage des Versorgungsfreibetrags */
    private final static double TAB2[] = {0, 3000, 2880, 2760, 2640, 2520, 2400, 2280, 2160, 2040, 1920, 1800, 1680, 1560, 1440, 1320, 1200, 1140, 1080, 1020, 960, 900, 840, 780, 720, 660, 600, 540, 480, 420, 360, 300, 240, 180, 120, 60, 0};

    /* Tabelle fuer die Zuschlaege zum Versorgungsfreibetrag */
    private final static double TAB3[] = {0, 900, 864, 828, 792, 756, 720, 684, 648, 612, 576, 540, 504, 468, 432, 396, 360, 342, 324, 306, 288, 270, 252, 234, 216, 198, 180, 162, 144, 126, 108, 90, 72, 54, 36, 18, 0};

    /* Tabelle fuer die Vomhundertsaetze des Altersentlastungsbetrags */
    private final static double TAB4[] = {0.0, 0.4, 0.384, 0.368, 0.352, 0.336, 0.32, 0.304, 0.288, 0.272, 0.256, 0.24, 0.224, 0.208, 0.192, 0.176, 0.16, 0.152, 0.144, 0.136, 0.128, 0.12, 0.112, 0.104, 0.096, 0.088, 0.08, 0.072, 0.064, 0.056, 0.048, 0.04, 0.032, 0.024, 0.016, 0.008, 0.0};

    /* Tabelle fuer die Hoechstbetraege des Altersentlastungsbetrags */
    private final static double TAB5[] = {0, 1900, 1824, 1748, 1672, 1596, 1520, 1444, 1368, 1292, 1216, 1140, 1064, 988, 912, 836, 760, 722, 684, 646, 608, 570, 532, 494, 456, 418, 380, 342, 304, 266, 228, 190, 152, 114, 76, 38, 0 };
 
    /* Zahlenkonstanten fuer im Plan oft genutzte BigDecimal Werte */
    //private final static double ZAHL0 = 0;
    //private final static double ZAHL1 = 1;
    private final static double ZAHL2 = 2;
    //private final static double ZAHL3 = 3;
    //private final static double ZAHL4 = 4;
    private final static double ZAHL5 = 5;
    //private final static double ZAHL6 = 6;
    private final static double ZAHL7 = 7;
    //private final static double ZAHL8 = 8;
    //private final static double ZAHL9 = 9;
    //private final static double ZAHL10 = 10;
    //private final static double ZAHL11 = 11;
    private final static double ZAHL12 = 12;
    private final static double ZAHL100 = 100;
    private final static double ZAHL360 = 360;
    private final static double ZAHL500 = 500;
    private final static double ZAHL700 = 700;
    private final static double ZAHL1000 = 1000;
    private final static double ZAHL10000 = 10000;
	  
	
	//Runden 2 Nachkommastellen (Cent)
	private double rundenCent( double zahl )
	{
		return ( Math.floor( ( zahl * 100) + 0.5 ) / 100 ); //Math.round funktioniert nicht...
	} 	
	private double abrundenCent( double zahl )
	{
		return ( Math.floor(zahl * 100) / 100 );
	}  	
	private double aufrundenCent( double zahl )
	{
		return ( Math.ceil(zahl * 100) / 100 );
	}  
	//Runden 0 Nachkommastellen (Euro)
	private double abrundenEuro( double zahl )
	{
		return Math.floor(zahl);
	}  	
	private double aufrundenEuro( double zahl )
	{
		return Math.ceil(zahl);
	}



	/* PROGRAMMABLAUFPLAN 2013, PAP Seite 11 */
	private void calculateSteuer2013()
  	{
	    MRE4JL();
	    VBEZBSO = 0;
		KENNVMT = 0;
		MRE4();
		MRE4ABZ();
		MZTABFB();
		MLSTJAHR();
		LSTJAHR = ST * f;  
		JW = LSTJAHR * ZAHL100;
		UPLSTLZZ();
		UPVKVLZZ();
	
		if(ZKF > 0)
		{
	        ZTABFB = ZTABFB + KFB;  
	        MRE4ABZ();
	        MLSTJAHR();
	        JBMG = ST * f;  
		}
	  	else
	  	{
	    	JBMG= LSTJAHR;
	   	}
		MSOLZ();
		MSONST();
		MVMT();
  	}

	/* PROGRAMMABLAUFPLAN 2016 */
	private void calculateSteuer2016()
  	{
	    MRE4JL();
	    VBEZBSO = 0;
		KENNVMT = 0;
		MRE4();
		MRE4ABZ();
		//ab hier weiter Unterberechnung seit dem Steuerjahr 2016 in MBERECH verschoben
		MBERECH();
		MSONST();
		MVMT();
  	}


  /* Ermittlung des Jahresarbeitslohns nach � 39 b Abs. 2 Satz 2 EStG, PAP Seite 12 */
	private void MRE4JL()
	{
		if( LZZ == 1 )
		{
	    	ZRE4J = RE4 / ZAHL100;
	    	ZVBEZJ = VBEZ / ZAHL100;
	    	JLFREIB = LZZFREIB / ZAHL100;
	    	JLHINZU = LZZHINZU / ZAHL100;
		}
		else
	    {
			if( LZZ == 2 )
			{
	        	ZRE4J = ( RE4 * ZAHL12 ) / ZAHL100;
	        	ZVBEZJ = ( VBEZ * ZAHL12 ) / ZAHL100;
	        	JLFREIB = ( LZZFREIB * ZAHL12 ) / ZAHL100;
	        	JLHINZU = ( LZZHINZU * ZAHL12 ) / ZAHL100;
	    	}
			else
			{
	        	if( LZZ == 3 )
	        	{
		            ZRE4J = ( RE4 * ZAHL360 ) / ZAHL700;
		            ZVBEZJ = ( VBEZ * ZAHL360 ) / ZAHL700;
		            JLFREIB = ( LZZFREIB * ZAHL360 ) / ZAHL700;
		            JLHINZU = ( LZZHINZU * ZAHL360 ) / ZAHL700;
	        	}
	        	else
	        	{
		            ZRE4J = ( RE4 * ZAHL360 ) / ZAHL100;
		            ZVBEZJ = ( VBEZ * ZAHL360 ) / ZAHL100;
		            JLFREIB = ( LZZFREIB * ZAHL360 ) / ZAHL100;
		            JLHINZU = ( LZZHINZU * ZAHL360 ) / ZAHL100;
	        	}
			}
	    }
	
		if( af == 0 )
		{
			f= 1;
		}
	}



  	/* Freibetr�ge f�r Versorgungsbez�ge, Altersentlastungsbetrag (� 39b Abs. 2 Satz 3 EStG), PAP Seite 13 */
  	private void MRE4()
  	{
  		if( ZVBEZJ == 0 )
  		{
		    FVBZ = 0;
		    FVB = 0;
		    FVBZSO = 0;
		    FVBSO = 0;
  		}
  		else
  		{
  			if( VJAHR < 2006 )
  			{
  				J = 1;
  			}
  			else
  			{
  				if( VJAHR < 2040 )
  				{
  					J = VJAHR - 2004;
  				}
  				else
  				{
  					J = 36;
  				}
  			}
  			if ( LZZ == 1 )
	  		{
	      	
		        VBEZB = ( VBEZM * ZMVB ) + VBEZS;
		        HFVB = TAB2[J] / ZAHL12 * ZMVB;
		        FVBZ = aufrundenEuro( TAB3[J] / ZAHL12 *  ZMVB );
	  		}
	  		else
	  		{
		        VBEZB = ( VBEZM * ZAHL12 ) + VBEZS;
		        HFVB = TAB2[J];
		        FVBZ = TAB3[J];
	  		}
	  		FVB = aufrundenCent( ( VBEZB * TAB1[J] ) / ZAHL100 );
	    	if( FVB > HFVB )
	    	{	
	    		FVB = HFVB;
	    	}
	    	//ab Steuerjahr 2016
			if( AKTUELLES_JAHR >= 2016 )
			{
				if( FVB > ZVBEZJ )
				{
					FVB = ZVBEZJ;
				}
			}
	        FVBSO = aufrundenCent( FVB + ( ( VBEZBSO * TAB1[J] ) / ZAHL100 ) );
	        if( FVBSO > TAB2[J] )
	        {
	        	FVBSO = TAB2[J];
	        } 
	        HFVBZSO = ( ( VBEZB + VBEZBSO ) / ZAHL100 ) - FVBSO;        
	        FVBZSO = aufrundenEuro( FVBZ + ( VBEZBSO / ZAHL100 ) );
	    	if( FVBZSO > HFVBZSO )
	    	{
	    		FVBZSO = aufrundenEuro ( HFVBZSO );
	    	}
		    if( FVBZSO > TAB3[J] )
		    {
		    	FVBZSO = TAB3[J];
		    }
		    HFVBZ= ( VBEZB / ZAHL100 ) - FVB;
		    if( FVBZ > HFVBZ )
		    {
		    	FVBZ = aufrundenEuro( HFVBZ );
		    }
	  	}
  		MRE4ALTE();
  	}


  /* Altersentlastungsbetrag (� 39b Abs. 2 Satz 3 EStG), PAP Seite 14 */
  	private void MRE4ALTE()
  	{
  		if( ALTER1 == 0 )
  		{
  			ALTE = 0;
  		}
  		else
  		{
  			if( AJAHR < 2006 )
  			{
  				K= 1;
  			}
  			else
  			{
  				if( AJAHR < 2040 )
  				{
  					K = AJAHR - 2004;
  				}
  				else
  				{
  					K = 36;	
  				}
  			}
  			BMG = ZRE4J - ZVBEZJ;
		    /* Lt. PAP muss hier auf ganze EUR gerundet werden */
		    ALTE = aufrundenEuro( BMG * TAB4[K] );
		    HBALTE = TAB5[K];
		    if( ALTE > HBALTE )
		    {
		    	ALTE= HBALTE;
		    }
  		}
  	}



  	/* Ermittlung des Jahresarbeitslohns nach Abzug der Freibetr�ge nach � 39 b Abs. 2 Satz 3 und 4 EStG, PAP Seite 16 */
  	private void MRE4ABZ()
  	{
  		ZRE4 = ZRE4J - FVB - ALTE - JLFREIB + JLHINZU;
  		if( ZRE4 < 0 )
  		{
  			ZRE4 = 0;
  		} 
  		ZRE4VP = ZRE4J;

  		if( KENNVMT == 2)
  		{
  			ZRE4VP = ZRE4VP - ( ENTSCH / ZAHL100 );
  		}
  		ZVBEZ = ZVBEZJ - FVB;

  		if( ZVBEZ < 0 ) 
  		{	 
  			ZVBEZ = 0; 
  		} 
  	}

  	
    /* Berechnung fuer laufende Lohnzahlungszeitraueme Seite 20*/
    //ab 2016 in Main (calculate Funktion)
  	//DBA T�rkei Funktionen ausgelassen (*VFR*)
  	private void MBERECH()
    {
  		MZTABFB();
  		MLSTJAHR();
		LSTJAHR = ST * f;  
		UPLSTLZZ();
		UPVKVLZZ();
	
		if(ZKF > 0)
		{
	        ZTABFB = ZTABFB + KFB;  
	        MRE4ABZ();
	        MLSTJAHR();
	        JBMG = ST * f;  
		}
	  	else
	  	{
	    	JBMG = LSTJAHR;
	   	}
		MSOLZ();
    }

  	/* Ermittlung der festen Tabellenfreibetr�ge (ohne Vorsorgepauschale), PAP Seite 17 */
  	private void MZTABFB()
  	{
  		ANP = 0;
  		if(	( ZVBEZ >= 0 ) && ( ZVBEZ < FVBZ ) )
  		{
  			FVBZ = ZVBEZ;
  		}
  		if( STKL < 6 )
  		{
  			if( ZVBEZ > 0 )
  			{
  				if( ( ZVBEZ - FVBZ ) < 102 )
  				{
  					ANP = aufrundenEuro( ZVBEZ - FVBZ);
  				}
  				else
  				{
  					ANP = 102;
  				}
  			}
  		}
  		else
  		{
  			FVBZ = 0;	
  			FVBZSO = 0;
  		}
  		
  		if( STKL < 6 )  
  		{
  			if( ZRE4 > ZVBEZ )
  			{
  				if( ( ZRE4 - ZVBEZ ) < ZAHL1000 )
	        	{
  					ANP = aufrundenEuro( ANP + ZRE4 - ZVBEZ );
	        	}
  				else
  				{
  					ANP = ANP + ZAHL1000;
  				}
  			}
	  	}
  		KZTAB = 1;
  		
  		switch( STKL )
  		{
  			case 1:
  				SAP = 36;
  			    KFB = ZKF * KINDERFREIBETRAG;
  			    break;
  			case 2:
  				EFA = ALLEINERZ_FREIBETRAG;
		        SAP = 36;
		        KFB = ZKF * KINDERFREIBETRAG;
  				break;
  			case 3:
  				KZTAB = 2;
		        SAP = 36;
		        KFB = ZKF * KINDERFREIBETRAG;
		      	break;
  			case 4:
  				SAP = 36;
		        KFB = ZKF * KINDERFREIBETRAG / 2;
		      	break;
  			case 5:
  				SAP = 36;
			    KFB = 0;
  				break;
			default:
				KFB = 0;		
  		}	
  		ZTABFB= EFA + ANP + SAP + FVBZ;
  	}



  	/* Ermittlung Jahreslohnsteuer, PAP Seite 18 */
  	private void MLSTJAHR()
  	{
  		UPEVP();
  		if( KENNVMT != 1 )
  		{
  			ZVE= ZRE4 - ZTABFB - VSP;
  			UPMLST();
  		}
  		else
  		{
  			ZVE= ZRE4 - ZTABFB - VSP - ( VMT / ZAHL100 ) - ( VKAPA / ZAHL100 );
  			if( ZVE < 0 )
  			{
  				ZVE = ( ZVE + ( VMT / ZAHL100 ) + ( VKAPA /ZAHL100 ) ) / ZAHL5;
  				UPMLST();
  				ST= ST * ZAHL5; 
  			}
  			else
  			{
  				UPMLST();
  				STOVMT = ST;
  				ZVE = ZVE + ( ( VMT + VKAPA ) / ZAHL500 );
  				UPMLST();
  				ST = ( ( ST - STOVMT ) * ZAHL5 ) + STOVMT;
  			}
  		}
  	}
  

	private void UPVKVLZZ()
	{
		 UPVKV();
		 JW = VKV;
		 UPANTEIL();
		 VKVLZZ = ANTEIL1;
	}	

 
  	private void UPVKV()
  	{
  		if( PKV > 0 )
  		{
  			if( VSP2 > VSP3 )
			{
  				VKV = VSP2 * ZAHL100;
			}
  			else
  			{
  				VKV = VSP3 * ZAHL100;
  			}
  		}
  		else
  		{
  			VKV = 0;
  		}
  	}
  
 
   private void UPLSTLZZ()
   {
	   JW = LSTJAHR * ZAHL100;
	   UPANTEIL();
	   LSTLZZ = ANTEIL1;
   }
	
	
	
	
  /* PAP Seite 20 Ermittlung der Jahreslohnsteuer aus dem Einkommensteuertarif */
  private void UPMLST()
  {
	  if( ZVE < 1 )
	  {
		  ZVE = 0;
		  X = 0; 
	  }
	  else
	  {
		  X= abrundenEuro( ZVE / KZTAB );
	  }
	  if( STKL < 5 )
	  {
		  UPTAB_SWITCHER();
	  }
	  else
	  {
		  MST5_6();
	  }
  }  


  
  /* 	Vorsorgepauschale (� 39b Absatz 2 Satz 5 Nummer 3 und Absatz 4 EStG)
  			Achtung: Es wird davon ausgegangen, dass	
  				a) Es wird davon ausge-gangen, dassa) f�r die BBG (Ost) 58.800 Euro und f�r die BBG (West) 69.600 Euro festgelegt wird sowie
  				b) der Beitragssatz zur Rentenversicherung auf 19,0 % gesenkt wird.
  			
  			PAP Seite 21  */
  	private void UPEVP()
  	{
  		if( KRV > 1 )
  		{
  			VSP1 = 0;
  		}
  		else
  		{
			if( ZRE4VP > BBGRV )
			{
				ZRE4VP = BBGRV;
			}
	        
	        VSP1 = ZRE4VP * TBSVORV;
	        VSP1 = VSP1 * RVSATZAN;
  		}
  		VSP2 = ZRE4VP * 0.12;
  		if( STKL == 3 )
  		{	
  			VHB = 3000;
  		}
  		else
  		{
  			VHB = 1900;
  		}
  		if( VSP2 > VHB )
  		{
  			VSP2 = VHB;
  		}
  		VSPN = aufrundenEuro( VSP1 + VSP2 );
  		MVSP();
  		if( VSPN > VSP )
  		{
  			VSP = VSPN;
  		}	
  	}
 


  	/* Vorsorgepauschale (�39b Abs. 2 Satz 5 Nr 3 EStG) Vergleichsberechnung fuer Guenstigerpruefung, PAP Seite 22 */
  	private void MVSP()
  	{
  		if( ZRE4VP > BBGKVPV )
  		{
  			ZRE4VP = BBGKVPV;
  		}

  		if( PKV > 0 )
  		{
		    if( STKL == 6 )
		    {
		    	VSP3 = 0;
		    }
		    else
		    {
		    	VSP3 = PKPV * ZAHL12 / ZAHL100;
				if( PKV == 2 )
				{
					VSP3 = VSP3 - (ZRE4VP * ( KVSATZAG + PVSATZAG ) );
				}
		    }
  		}
  		else
  		{
			VSP3 = ZRE4VP * ( KVSATZAN + PVSATZAN );
  		}
  		VSP = aufrundenEuro( VSP3 + VSP1 );
  	}

  	/* Lohnsteuer fuer die Steuerklassen V und VI (� 39b Abs. 2 Satz 7 EStG), PAP Seite 23 */
  	private void MST5_6()
  	{
  		ZZX = X;
  		if( ZZX > GRENZW2_STKL5 )
  		{
  			ZX = GRENZW2_STKL5;
  			UP5_6();
  			if( ZZX > GRENZW3_STKL5 )
  			{
  				ST = ( ST + ( ( GRENZW3_STKL5 -  GRENZW2_STKL5 ) * 0.42 ) );
  				ST = abrundenCent( ST + ( ( ZZX - GRENZW3_STKL5 ) * 0.45 ) );
  			}
  			else
  			{
  				ST = abrundenEuro( ST + ( ( ZZX -  GRENZW2_STKL5 ) * 0.42 ) );
  			}
  		}
  		else
  		{
  			ZX = ZZX;
  			UP5_6();
  			//ge�ndert ab M�rz 2013, vorher:  if( ZZX > 9429 )
  			if( ZZX > GRENZW1_STKL5 )
  			{
  				VERGL = ST;
  				ZX = GRENZW1_STKL5;
  				UP5_6();
  				HOCH = abrundenEuro( ST + ( ( ZZX - GRENZW1_STKL5 ) * 0.42 ) );
  				if( HOCH < VERGL ) 
  				{
  					ST = HOCH;
  				}
  				else
  				{
  					ST= VERGL;
  				}
  			}
  		}
  	}

  
  
  	/* Unterprogramm zur Lohnsteuer fuer die Steuerklassen V und VI (� 39b Abs. 2 Satz 7 EStG), PAP Seite 21 */
  	private void UP5_6()
  	{
  		X = ZX * 1.25;
  		UPTAB_SWITCHER();
  		ST1 = ST;
  		X = ZX * 0.75;
  		UPTAB_SWITCHER();
  		ST2 = ST;
  		DIFF = ( ST1 - ST2 ) * ZAHL2;
  		MIST = abrundenEuro( ZX * 0.14 );
  		if( MIST > DIFF )
  		{
  			ST = MIST;
  		}
  		else
  		{
  			ST= DIFF;
  		}
  	}



  	/* Solidaritaetszuschlag, PAP Seite 24 */
  	private void MSOLZ()
  	{
  		SOLZFREI = 972 * KZTAB; //972 ist freigrenze f�r Soli, �ber die Jahre immer konstant geblieben
  		if( JBMG > SOLZFREI )
  		{
  			SOLZJ = abrundenCent( JBMG * 5.5 / ZAHL100 );
  			SOLZMIN = ( JBMG - SOLZFREI ) * 20 / ZAHL100;
  			if( SOLZMIN < SOLZJ )
  			{
  				SOLZJ = SOLZMIN;
  			}
  			JW = SOLZJ * ZAHL100;
  			UPANTEIL();
  			SOLZLZZ = ANTEIL1;
  		}
  		else
  		{
  			SOLZLZZ = 0;
  		}
  		if( R > 0 )
  		{
  			JW = JBMG * ZAHL100;
  			UPANTEIL();
  			BK = ANTEIL1;
  		}
  		else
  		{
  			BK = 0;
  		}
  	}



  	/* Anteil von Jahresbetraegen fuer einen LZZ (� 39b Abs. 2 Satz 9 EStG), PAP Seite 25 */
  	private void UPANTEIL()
  	{
  		switch( LZZ )
  		{
  		case 1:
  			ANTEIL1 = JW;
  			break;
  		case 2:
  			ANTEIL1 = abrundenCent( JW / ZAHL12 );
  			break;
  		case 3:
  			ANTEIL1 = abrundenCent( ( JW * ZAHL7 ) / ZAHL360 );
  			break;
  		default:
  			ANTEIL1 = abrundenCent ( JW / ZAHL360 );
  		}
  	}



  	/* Berechnung sonstiger Bezuege nach � 39b Abs. 3 Saetze 1 bis 8 EStG), PAP Seite 26 */
  	private void MSONST()
  	{
  		LZZ = 1;
  		if( ZMVB == 0 )
  		{
  			ZMVB = 12;
  		}
  		if( SONSTB == 0 )
  		{
  			VKVSONST = 0;
  			LSTSO = 0;
  			STS = 0;
  			SOLZS = 0;
  			BKS = 0;
  		}
  		else
  		{
  			MOSONST();
  			UPVKV();
  			VKVSONST = VKV;
  			ZRE4J = ( ( JRE4 + SONSTB ) / ZAHL100 );
  			ZVBEZJ = ( ( JVBEZ + VBS ) / ZAHL100 );
  			VBEZBSO = STERBE;
  			MRE4SONST();
  			MLSTJAHR();
  			UPVKV();
  			VKVSONST = VKV - VKVSONST;
  			LSTSO = ST * ZAHL100;
  			/* 	lt. PAP muss hier auf ganze EUR aufgerundet werden, 
    			allerdings muss der Wert in Cent vorgehalten werden,
    			deshalb nach dem Aufrunden auf ganze EUR durch 'divide(ZAHL100, 0, BigDecimal.ROUND_DOWN)'
    			wieder die Multiplikation mit 100 */
  			STS = abrundenEuro( ( LSTSO - LSTOSO ) * f );
  			if( STS < 0 )
  			{
  				STS = 0;
  			}
  			SOLZS = abrundenCent( STS * 5.5 / ZAHL100 );
  			if( R > 0 )
  			{
  				BKS = STS;
  			}
  			else
  			{
  				BKS = 0;
  			}
  		}
  	}



  	/* Berechnung der Verguetung fuer mehrjaehrige Taetigkeit nach � 39b Abs. 3 Satz 9 und 10 EStG), PAP Seite 27 */
  	private void MVMT()
  	{
  		if( VKAPA < 0 )
  		{
  			VKAPA = 0;
  		}
  		if( ( VMT + VKAPA ) > 0 )
  		{
  			if( LSTSO == 0 )
  			{
  				MOSONST();
  				LST1 = LSTOSO;
  			}
  			else
  			{
  				LST1 = LSTSO;
  			}
	  		VBEZBSO = STERBE + VKAPA;
	  		ZRE4J = ( JRE4 + SONSTB + VMT + VKAPA ) / ZAHL100;
	  		ZVBEZJ = ( JVBEZ + VBS + VKAPA ) / ZAHL100;
	  		KENNVMT = 2;
	    	MRE4SONST();
	    	MLSTJAHR();
	    	LST3 = ST * ZAHL100;
	    	MRE4ABZ();
	    	ZRE4VP = ZRE4VP - ( JRE4ENT /ZAHL100 ) - ( SONSTENT /ZAHL100 );
	    	KENNVMT = 1;
	    	MLSTJAHR();
	    	LST2 = ST * ZAHL100;
	    	STV = LST2 - LST1;
	    	LST3 = LST3 - LST1;
	    	if( LST3 < STV )
	    	{
	    		STV = LST3;
	    	}
	    	if( STV < 0 )
	    	{
	    		STV = 0;
	    	}
	    	else
	    	{
	        	/*	
	        		lt. PAP muss hier auf ganze EUR abgerundet werden.
	        	Allerdings muss auch hier der Wert in Cent vorgehalten werden,
	    			weshalb nach dem Aufrunden auf ganze EUR durch 'divide(ZAHL100, 0, BigDecimal.ROUND_DOWN)'
	    			wieder die Multiplikation mit 100 erfolgt.
	    		*/
	        	STV = abrundenEuro( STV * f );
	    	}
			SOLZV = abrundenCent( STV * 5.5 / ZAHL100 );
	    	if( R > 0 )
	    	{
	    		BKV = STV;
	    	}
	    	else
	    	{
	    		BKV = 0;
	    	}
  		}
  		else
  		{ 
  			STV = 0;
  			SOLZV = 0;
  			BKV = 0;
  		}
  	}


  	
  	/* Sonderberechnung ohne sonstige Bez�ge f�r Berechnung bei sonstigen Bez�gen oder Verg�tung f�r mehrj�hrige T�tigkeit, PAP Seite 26 */
  	private void MOSONST()
  	{
		ZRE4J = JRE4 / ZAHL100;
		ZVBEZJ = JVBEZ / ZAHL100;
		JLFREIB = JFREIB / ZAHL100;
		JLHINZU = JHINZU / ZAHL100;
		MRE4();
		MRE4ABZ();
		ZRE4VP = ZRE4VP - (JRE4ENT / ZAHL100);
		MZTABFB();
		MLSTJAHR();
		LSTOSO = ST * ZAHL100;
  	}


  	
  	/* Sonderberechnung mit sonstige Bez�ge f�r Berechnung bei sonstigen Bez�gen oder Verg�tung f�r mehrj�hrige T�tigkeit, PAP Seite 26 */
  	private void MRE4SONST()
  	{
		MRE4();
		FVB = FVBSO;
		MRE4ABZ();
		ZRE4VP = ZRE4VP - (JRE4ENT / ZAHL100) - (SONSTENT / ZAHL100);
		FVBZ = FVBZSO;
		MZTABFB();
  	}
  
  	
  
	//UPTAB_SWITCHER um zwischen verschiedenen Jahren umschalten zu k�nnen ( geht nur solange struktur kompatibel bleibt )!!!
	private void UPTAB_SWITCHER()
	{
		switch ( AKTUELLES_JAHR )
		{
		case 2013:
			UPTAB13();
		break;
  		case 2014:
  		case 2015:
			UPTAB14();
		break;
        case 2016:
            UPTAB16();
        break;
        case 2017:
            UPTAB17();
        break;       
		case 2018:
            UPTAB18();
        break;		
		case 2019:
            UPTAB19();
        break;
		}
	}
	
	

  	private void UPTAB13()
  	{
  		if( X < 8131 )
  		{
  			ST = 0;
  		}
  		else
  		{
  			if( X < 13470 )
  			{
  				Y = ( X - 8130 ) / 10000;
		        RW = Y * 933.7;
		        RW = RW + 1400;
		        ST = abrundenEuro( RW * Y );
  			}
  			else
  			{
  				if( X < 52882 )
  				{
  					Y = ( X - 13469 ) / 10000;
  					RW = Y * 228.74;
		            RW = RW + 2397;
		            RW = RW * Y;
		            ST = abrundenEuro( RW + 1014 );
  				}
  				else
  				{
  					if( X < 250731 )
  					{
  						ST = abrundenEuro( ( X * 0.42 ) - 8196 );
  					}
  					else
  					{
  						ST = abrundenEuro( ( X * 0.45 ) - 15718 );
  					}
  				}
  			}
  		}
  		ST = ST * KZTAB;
  	}
	
	
  	
	private void UPTAB14()
  	{
  		if( X < 8355 )
  		{
  			ST = 0;
  		}
  		else
  		{
  			if( X < 13470 )
  			{
  				Y = ( X - 8354 ) / 10000;
		        RW = Y * 974.58;
		        RW = RW + 1400;
		        ST = abrundenEuro( RW * Y );
  			}
  			else
  			{
  				if( X < 52882 )
  				{
  					Y = ( X - 13469 ) / 10000;
  					RW = Y * 228.74;
		            RW = RW + 2397;
		            RW = RW * Y;
		            ST = abrundenEuro( RW + 971 );
  				}
  				else
  				{
  					if( X < 250731 )
  					{
  						ST = abrundenEuro( ( X * 0.42 ) - 8239 );
  					}
  					else
  					{
  						ST = abrundenEuro( ( X * 0.45 ) - 15761 );
  					}
  				}
  			}
  		}
  		ST = ST * KZTAB;
  	}

    private void UPTAB16()
    {
        if( X < ( GFB + 1 ) )
        {
            ST = 0;
        }
        else
        {
            if( X < 13670 )
            {
                Y = ( X - GFB ) / ZAHL10000;
                RW = Y * 993.62;
                RW = RW + 1400;
                ST = abrundenEuro( RW * Y );
            }
            else
            {
                if( X < 53666 )
                {
                    Y = ( X - 13669 ) / ZAHL10000;
                    RW = Y * 225.40;
                    RW = RW + 2397;
                    RW = RW * Y;
                    ST = abrundenEuro( RW + 952.48 );
                }
                else
                {
                    if( X < 254447 )
                    {
                        ST = abrundenEuro( ( X * 0.42 ) - 8394.14 );
                    }
                    else
                    {
                        ST = abrundenEuro( ( X * 0.45 ) - 16027.52 );
                    }
                }
            }
        }
        ST = ST * KZTAB;
    }

    private void UPTAB17()
    {
        if( X < ( GFB + 1 ) )
        {
            ST = 0;
        }
        else
        {
            if( X < 13770 )
            {
                Y = ( X - GFB ) / ZAHL10000;
                RW = Y * 1007.27;
                RW = RW + 1400;
                ST = abrundenEuro( RW * Y );
            }
            else
            {
                if( X < 54058 )
                {
                    Y = ( X - 13769 ) / ZAHL10000;
                    RW = Y * 223.76;
                    RW = RW + 2397;
                    RW = RW * Y;
                    ST = abrundenEuro( RW + 939.57 );
                }
                else
                {
                    if( X < 256304 )
                    {
                        ST = abrundenEuro( ( X * 0.42 ) - 8475.44 );
                    }
                    else
                    {
                        ST = abrundenEuro( ( X * 0.45 ) - 16164.53 );
                    }
                }
            }
        }
        ST = ST * KZTAB;
    }
	
    private void UPTAB18()
    {
        if( X < ( GFB + 1 ) )
        {
            ST = 0;
        }
        else
        {
            if( X < 13997 )
            {
                Y = ( X - GFB ) / ZAHL10000;
                RW = Y * 997.8;
                RW = RW + 1400;
                ST = abrundenEuro( RW * Y );
            }
            else
            {
                if( X < 54950 )
                {
                    Y = ( X - 13996 ) / ZAHL10000;
                    RW = Y * 220.13;
                    RW = RW + 2397;
                    RW = RW * Y;
                    ST = abrundenEuro( RW + 948.49 );
                }
                else
                {
                    if( X < 260533 )
                    {
                        ST = abrundenEuro( ( X * 0.42 ) - 8621.75 );
                    }
                    else
                    {
                        ST = abrundenEuro( ( X * 0.45 ) - 16437.7 );
                    }
                }
            }
        }
        ST = ST * KZTAB;
    }	
	
	private void UPTAB19()
    {
        if( X < ( GFB + 1 ) )
        {
            ST = 0;
        }
        else
        {
            if( X < 14255 )
            {
                Y = ( X - GFB ) / ZAHL10000;
                RW = Y * 980.14;
                RW = RW + 1400;
                ST = abrundenEuro( RW * Y );
            }
            else
            {
                if( X < 55961 )
                {
                    Y = ( X - 14254 ) / ZAHL10000;
                    RW = Y * 216.16;
                    RW = RW + 2397;
                    RW = RW * Y;
                    ST = abrundenEuro( RW + 965.58 );
                }
                else
                {
                    if( X < 265327 )
                    {
                        ST = abrundenEuro( ( X * 0.42 ) - 8780.9 );
                    }
                    else
                    {
                        ST = abrundenEuro( ( X * 0.45 ) - 16740.68 );
                    }
                }
            }
        }
        ST = ST * KZTAB;
    }

}
