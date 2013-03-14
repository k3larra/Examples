Examples
========

Some Java examples

ThreadTest: Ett exempel med tråd där man använder en extern klass som implementerar gränssnittet runnable (I exemplet heter denna klass TaskRunner). Detta gör att man kan starta en tråd Thread som kör klassen TaskRunner, det gör jag från klassen TestGUI. Detta sättet att arbeta med trådar är bra om koden i tråden är omfattande och man vill ha bättre kontroll så man kan stoppa eller ändra frekvens för hur ofta tråden kör. Det negativa här är att klassen TaskRunner är beroende av TestGUI och att det finns en stark koppling mellan dem. Det gör att tråden inte kan användas av andra klasser än TestGUI (Om man vill göra det får man implementera ett listener pattern).  

TaskRunner: I detta exempel använder jag en klass som utvidgar ett TimerTask som jag skrivit som en inre klass. Jag använder då en Timer för att köra mitt TimerTask. En bra konstruktion om det är lite kod som skall köras tråden och koden i den andra klassen kör relativt sällan.   
