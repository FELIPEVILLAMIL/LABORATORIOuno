package aeropuertogestion1;

public class AeropuertoGestion1 {
    
        public static String auxnombre=null;
        public static int auxid=0;
        public static boolean [][] mSillaEj=new boolean [2][4];
        public static boolean [][] mSillaEc=new boolean [7][6];
        public static int [] mID=new int [50];
        public static String [] mNombre=new String [50];
         
    public static void VaciarSi(){
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                AeropuertoGestion1.mSillaEj[i][j]=true;
            }
        }
    }  
    
    public static void VaciarSiEc(){
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                AeropuertoGestion1.mSillaEc[i][j]=true;
            }
        }
    }  
        
    public static void funcionpedir(){
        java.util.Scanner lectura= new java.util.Scanner(System.in);   
        System.out.println("DIGITAR NOMBRE");
        AeropuertoGestion1.auxnombre=lectura.next();
        System.out.println("DIGITAR ID");
        AeropuertoGestion1.auxid=lectura.nextInt();
    }
    public static void fEscogerClase(){
        java.util.Scanner lectura= new java.util.Scanner(System.in);
        int Select;
        do{
            System.out.println("PRESIONE 0-EJECUTIVO o 1-ECONOMICO");
            Select=lectura.nextInt();
            switch (Select) {
                case 0:
                    fEscogerPeje();
                    break;
                case 1:
                    fEscogerPeco();
                    break;
                default:
                    System.out.println("ERROR OPCION NO VALIDA");
                    break;
            }
        }while((Select!=1)&&(Select!=0));
    }
    
    public static void fEscogerPeje(){
        java.util.Scanner lectura= new java.util.Scanner(System.in);
        String Select;
        do{
            System.out.println("PRESIONE 0-VENTANA , 1-PASILLO");
            Select=lectura.next();
            if(null!=Select)switch (Select) {
                case "0":
                    fRecorrerEje(0);
                    break;
                case "1":
                    fRecorrerEje(1);
                    break;
                default:
                    System.out.println("ERROR OPCION NO VALIDA");
                    break;
            }
        }while((!"1".equals(Select))&&(!"0".equals(Select)));
        
    }
    
        public static void fEscogerPeco(){
        java.util.Scanner lectura= new java.util.Scanner(System.in);
        String Select;
        do{
            System.out.println("PRESIONE 0-VENTANA ,1-CENTRO ,2-PASILLO");
            Select=lectura.next();
            if(null!=Select)switch (Select) {
                case "0":
                    fRecorrerEc(0);
                    break;
                case "1":
                    fRecorrerEc(1);
                    break;
                case "2":
                    fRecorrerEc(2);
                    break;
                default:
                    System.out.println("ERROR OPCION NO VALIDA");
                    Select="9";
                    break;
            }
        }while(("9".equals(Select)));
    }    
    
    public static void fRecorrerEje(int Select){
        int aux;
        int aux2;
        while(Select==0||Select==1){
            aux2=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){ 
                if(AeropuertoGestion1.mSillaEj[i][j]==true){
                  if(Select==0){
                    if (j==0){
                       System.out.println("Se le ha asignado:");
                       System.out.println("VENTANA IZQUIERDA-FILA:"+(i+1)); 
                       aux=fIterar();
                       if(aux==1){
                          AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                          AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                          AeropuertoGestion1.mSillaEj[i][j]=false; 
                          System.out.println("CONFIRMADO");
                          i=2;
                          j=4;
                          Select=4;
                       }
                    }else if(j==3){
                       System.out.println("Se le ha asignado:");  
                       System.out.println("VENTANA DERECHA-FILA:"+(i+1));
                       aux=fIterar();
                       if(aux==1){
                          AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                          AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                          AeropuertoGestion1.mSillaEj[i][j]=false;
                          System.out.println("CONFIRMADO");
                          i=2;
                          j=4;
                          Select=4;
                       }
                    }
                  }else if(Select==1){
                      if (j==1){
                       System.out.println("Se le ha asignado:");
                       System.out.println("PASILLO IZQUIERDO-FILA:"+(i+1)); 
                       aux=fIterar();
                       if(aux==1){
                          AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid; 
                          AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                          AeropuertoGestion1.mSillaEj[i][j]=false;
                          System.out.println("CONFIRMADO");
                          i=2;
                          j=4;
                          Select=4;
                       }
                    }else if(j==2){
                       System.out.println("Se le ha asignado:");  
                       System.out.println("PASILLO DERECHO-FILA:"+(i+1));
                       aux=fIterar();
                       if(aux==1){ 
                          AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                          AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                          AeropuertoGestion1.mSillaEj[i][j]=false;//CAMBIA DE ESTADO A OCUPADA
                          System.out.println("CONFIRMADO");
                          i=2;//PONGO ESTAS TRES VARIABLES COMO FORMA DE ESCAPE DEL CICLO
                          j=4;
                          Select=4;
                       }
                    }
                      
                  }
                  
                }
                    
               aux2++; 
            }
        }
        
      }
    }
    
    public static void fRecorrerEc(int Select){
        int aux;
        int aux2;
        int scp=0;
        while(scp==0){
            aux2=8;
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){ 
                if(AeropuertoGestion1.mSillaEc[i][j]==true){
                    switch (Select) {
                        case 0:
                            if (j==0){
                                System.out.println("Se le ha asignado:");
                                System.out.println("VENTANA IZQUIERDA-FILA:"+(i+1));
                                aux=fIterar();
                                if(aux==1){
                                    AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                                    AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                                    AeropuertoGestion1.mSillaEc[i][j]=false;
                                    System.out.println("CONFIRMADO");
                                    i=7;
                                    j=6;
                                    scp=4;
                                }
                            }else if(j==5){
                                System.out.println("Se le ha asignado:");
                                System.out.println("VENTANA DERECHA-FILA:"+(i+1));
                                aux=fIterar();
                                if(aux==1){
                                    AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                                    AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                                    AeropuertoGestion1.mSillaEc[i][j]=false;
                                    System.out.println("CONFIRMADO");
                                    i=7;
                                    j=6;
                                    scp=4;
                                }
                            }       break;
                        case 1:
                            if (j==1){
                                System.out.println("Se le ha asignado:");
                                System.out.println("CENTRO IZQUIERDO-FILA:"+(i+1));
                                aux=fIterar();
                                if(aux==1){
                                    AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                                    AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                                    AeropuertoGestion1.mSillaEc[i][j]=false;
                                    System.out.println("CONFIRMADO");
                                    i=7;
                                    j=6;
                                    scp=4;
                                }
                            }else if(j==4){
                                System.out.println("Se le ha asignado:");
                                System.out.println("CENTRO DERECHO-FILA:"+(i+1));
                                aux=fIterar();
                                if(aux==1){
                                    AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                                    AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                                    AeropuertoGestion1.mSillaEc[i][j]=false;//CAMBIA DE ESTADO A OCUPADA
                                    System.out.println("CONFIRMADO");
                                    i=7;//PONGO ESTAS TRES VARIABLES COMO FORMA DE ESCAPE DEL CICLO
                                    j=6;
                                    scp=4;
                                }
                            }       break;
                        case 2:
                            if (j==2){
                                System.out.println("Se le ha asignado:");
                                System.out.println("PASILLO IZQUIERDO-FILA:"+(i+1));
                                aux=fIterar();
                                if(aux==1){
                                    AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                                    AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                                    AeropuertoGestion1.mSillaEc[i][j]=false;
                                    System.out.println("CONFIRMADO");
                                    i=7;
                                    j=6;
                                    scp=4;
                                }
                            }else if(j==3){
                                System.out.println("Se le ha asignado:");
                                System.out.println("PASILLO DERECHO-FILA:"+(i+1));
                                aux=fIterar();
                                if(aux==1){
                                    AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                                    AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                                    AeropuertoGestion1.mSillaEc[i][j]=false;//CAMBIA DE ESTADO A OCUPADA
                                    System.out.println("CONFIRMADO");
                                    i=7;//PONGO ESTAS TRES VARIABLES COMO FORMA DE ESCAPE DEL CICLO
                                    j=6;
                                    scp=4;
                                }
                            }       break;
                        default:
                            break;
                    }
                  
                }
                    
               aux2++; 
            }
        }
        
      }
    }
    
    public static int fIterar(){
        String i="a";
        int x=3;
        java.util.Scanner lectura= new java.util.Scanner(System.in);
        while(!("1".equals(i)||"0".equals(i))){
        System.out.println("Oprima 1 para confirmar o 0 para continuar busqueda");
        i=lectura.next();
        if("1".equals(i)){
            x=1;
        }else if("0".equals(i)){
            x=0;
        }          
        }
        return x;
    }
    
    public static void fWindow(){
      boolean Salir =false;
      String estado;
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      while(Salir==false){
          System.out.println("Digite 'SA' para terminar,'ME' para ir a gestion o 'IN' ingresar nuevo pasajero");
        estado=lectura.next();
        if(null != estado)switch (estado) {
              case "SA":
                  Salir=true;
                  break;
              case "ME":
                  fMenu();
                  break;
              case "IN":
                  funcionpedir();
                  fEscogerClase();
                  System.out.println("INGRESO NUEVO PASAJERO");
                  break;
              default:
                  System.out.println("ERROR, INTENTE DE NUEVO");
                  break;
          }
      }
        
      
    }
    
    public static void fMenu(){
      boolean Salir =false;
      String estado;
      java.util.Scanner lectura= new java.util.Scanner(System.in);
      while(Salir==false){
          //MODIFICANDO PARA HACER EL MENU DE OCHO OPCIONES CON CASE
          System.out.println("");
          System.out.println("Digite '1' Contar puestos ejecutivos ocupados");
          System.out.println("Digite '2' Localizar pasajero por cedula");
          System.out.println("Digite '3' Localizar una silla economica disponible");
          System.out.println("Digite '4' Asignar un pasajero a una silla economica");
          System.out.println("Digite '5' Anular una reserva");
          System.out.println("Digite '6' Contar puestos economicos ventana libres");
          System.out.println("Digite '7' Identifcar dos pasajeros con el mismo nombre");
          System.out.println("Digite '8' VOLVER AL MENU PRINCIPAL");
        estado=lectura.next();
        if(null != estado)switch (estado) {
              case "1":
                  System.out.print("HAY "+fContarEj()+ " PUESTOS OCUPADOS");
                  break;
              case "2":
                  fBuscarCed();
                  break;
              case "3":
                  fLocalEc(true);
                  break;
              case "4":
                  fLocalEc(false);
                  break;
              case "5":
                  fAnular();
                  break;
              case "6":
                  System.out.print("HAY "+fContarEcVent()+ " PUESTOS LIBRES");//HAY QUE MODIFICARLE EL TAMAÑO Y CAMBIAR A MATRIZ ECONOMICA
                  break;
              case "7":
                  fBuscarNom();
                  break;
              case "8":
                  Salir=true;
                  break;
              default:
                  System.out.println("ERROR, INTENTE DE NUEVO");
                  break;
          }
      }
        
    }
   
    public static int fContarEj(){
        int PuOcupados=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){ 
                if(AeropuertoGestion1.mSillaEj[i][j]==true){
                    System.out.print("|O|");
                    
                }else{
                    System.out.print("|X|");
                   PuOcupados++;
                }
                if(j==1){
                        System.out.print("|  |");
                }
            }
           System.out.println("");
        }
        return PuOcupados;
    } 
    
    public static int fContarEc(){
        int PuOcupados=0;
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){ 
                if(AeropuertoGestion1.mSillaEc[i][j]==true){
                    System.out.print("|O|");
                    
                }else{
                    System.out.print("|X|");
                   PuOcupados++;
                }
                if(j==2){
                        System.out.print("|  |");
                }
            }
           System.out.println("");
        }
        return PuOcupados;
    }  
    
    public static int fContarEcVent(){
        int PuLibres=0;
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){ 
                if(AeropuertoGestion1.mSillaEc[i][j]==true){
                    System.out.print("|O|");
                    if(j==0||j==5){
                     PuLibres++;   
                    }
                }else{
                    System.out.print("|X|");
                }
                    if(j==2){
                        System.out.print("|  |");
                    }              
            }
           System.out.println("");
        }
        return PuLibres;
    }
    public static String fBuscarCed(){
    String res=null;
    int aux;
    boolean Select=true;
    java.util.Scanner lectura= new java.util.Scanner(System.in);
    while(Select==true){
        System.out.println("Digite cedula:");
        aux=lectura.nextInt();
        for(int i=0;i<50;i++){
            if(AeropuertoGestion1.mID[i]==aux){
                Select=false;
                if(i<=7){
                    System.out.println("SE ENCUENTRA EN CLASE EJECUTIVA");
                    int cont=0;
                    int jpri=50;
                    int kpri=50;
                    for(int j=0;j<2;j++){
                        for(int k=0;k<4;k++){ 
                            if(i==cont){
                              jpri=j;
                              kpri=k;
                            }
                            cont++;
                        }
                    }
                    switch (kpri) {
                        case 0:
                            System.out.println("VENTANA IZQUIERDA FILA "+(jpri+1));
                            break;
                        case 1:
                            System.out.println("PASILLO IZQUIERDO FILA "+(jpri+1));
                            break;
                        case 2:
                            System.out.println("PASILLO DERECHO FILA "+(jpri+1));
                            break;
                        case 3:
                            System.out.println("VENTANA DERECHA FILA "+(jpri+1));
                            break;
                        default:
                            break;
                    }
                    fContarEj();
                    i=50;
                }else{
                    System.out.println("SE ENCUENTRA EN CLASE ECONOMICA");
                    int cont=8;
                    int jpri=50;
                    int kpri=50;
                    for(int j=0;j<7;j++){
                        for(int k=0;k<6;k++){ 
                            if(i==cont){
                              jpri=j;
                              kpri=k;
                            }
                            cont++;
                        }
                    }
                    switch (kpri) {
                        case 0:
                            System.out.println("VENTANA IZQUIERDA FILA "+(jpri+1));
                            break;
                        case 1:
                            System.out.println("PASILLO IZQUIERDO FILA "+(jpri+1));
                            break;
                        case 2:
                            System.out.println("CENTRO IZQUIERDO FILA "+(jpri+1));
                            break;
                        case 3:
                            System.out.println("CENTRO DERECHO FILA "+(jpri+1));
                            break;                   
                        case 4:
                            System.out.println("PASILLO DERECHO FILA "+(jpri+1));
                            break;
                        case 5:
                            System.out.println("VENTANA DERECHA FILA "+(jpri+1));                          
                            break;
                        default:
                            break;
                    }
                    fContarEc();
                    i=50;
                }
               
            }
        }
       if(Select==true){
           System.out.println("NO SE ENCUENTRA");
           Select=false;
       }
    }
       return res;
    }
    public static void fBuscarNom(){
    
       for(int i=0;i<50;i++){
        for(int j=0;j<50;j++){
            if(i!=j){
            if((AeropuertoGestion1.mNombre[i] == null ? AeropuertoGestion1.mNombre[j] == null : AeropuertoGestion1.mNombre[i].equals(AeropuertoGestion1.mNombre[j]))&&(AeropuertoGestion1.mNombre[i]!=null)){
                System.out.println("Se encontraron dos pasajeros con el mismo nombre");
                System.out.println("1."+AeropuertoGestion1.mNombre[i]);
                System.out.println(AeropuertoGestion1.mID[i]);
                System.out.println("2."+AeropuertoGestion1.mNombre[j]);
                System.out.println(AeropuertoGestion1.mID[j]);
                j=50;
                i=50;
             
                     }
            }else if(i==49&&j==49){
                System.out.println("NO SE ENCONTRARON PASAJEROS CON EL MISMO NOMBRE");
            } 
           
        }
    }
    }
    
    public static void fLocalEc(boolean varia){
        int aux2=0;
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){ 
                
                if(AeropuertoGestion1.mSillaEc[i][j]==true){
                    System.out.print("SILLA LIBRE ");
                    switch (j) {
                        case 0:
                            System.out.println("VENTANA IZQUIERDA FILA "+(i+1));
                            break;
                        case 1:
                            System.out.println("CENTRO IZQUIERDO FILA "+(i+1));
                            break;
                        case 2:
                            System.out.println("PASILLO IZQUIERDO FILA "+(i+1));
                            break;
                        case 3:
                            System.out.println("PASILLO DERECHO FILA "+(i+1));
                            break;
                        case 4:
                            System.out.println("CENTRO DERECHO FILA "+(i+1));
                            break;
                        case 5:
                            System.out.println("VENTANA DERECHA FILA "+(i+1));
                            break;                    
                        default:
                            break;
                        
                    }
                    if(varia==false){
                    funcionpedir();
                    AeropuertoGestion1.mSillaEc[i][j]=false;
                    AeropuertoGestion1.mID[aux2]= AeropuertoGestion1.auxid;
                    AeropuertoGestion1.mNombre[aux2]= AeropuertoGestion1.auxnombre;
                    }
                    i=8;
                    j=8;
                    fContarEc();
              
                }else if(aux2==42){
                    System.out.println("NO HAY SILLA LIBRE ");
                }
              aux2++;
            }
           System.out.println("");
        }
       
    }
    public static void fAnular(){
        System.out.println("DIGITE DATOS DEL PASAJERO A ANULAR");
        funcionpedir();
    String res=null;
    int aux;
    boolean Select=true;
    java.util.Scanner lectura= new java.util.Scanner(System.in);
    while(Select==true){
        aux=AeropuertoGestion1.auxid;
        for(int i=0;i<50;i++){
            if(AeropuertoGestion1.mID[i]==aux){
                Select=false;
                if(i<=7){
                    System.out.println("SE ENCUENTRA EN CLASE EJECUTIVA");
                    int cont=0;
                    int jpri=50;
                    int kpri=50;
                    for(int j=0;j<2;j++){
                        for(int k=0;k<4;k++){ 
                            if(i==cont){
                              jpri=j;
                              kpri=k;
                              AeropuertoGestion1.mSillaEj[i][j]=true;//CAMBIA DE ESTADO A OCUPADA
                              System.out.println("CONFIRMADO");
                            }
                            cont++;
                        }
                    }
                    switch (kpri) {
                        case 0:
                            System.out.println("VENTANA IZQUIERDA FILA "+(jpri+1));
                            break;
                        case 1:
                            System.out.println("PASILLO IZQUIERDO FILA "+(jpri+1));
                            break;
                        case 2:
                            System.out.println("PASILLO DERECHO FILA "+(jpri+1));
                            break;
                        case 3:
                            System.out.println("VENTANA DERECHA FILA "+(jpri+1));
                            break;
                        default:
                            break;
                    }
                    fContarEj();
                    i=50;
                }else{
                    System.out.println("SE ENCUENTRA EN CLASE ECONOMICA");
                    int cont=8;
                    int jpri=50;
                    int kpri=50;
                    for(int j=0;j<7;j++){
                        for(int k=0;k<6;k++){ 
                            if(i==cont){
                              jpri=j;
                              kpri=k;
                              AeropuertoGestion1.mSillaEc[i][j]=true;//CAMBIA DE ESTADO A OCUPADA
                              System.out.println("CONFIRMADO");
                            }
                            cont++;
                        }
                    }
                    switch (kpri) {
                        case 0:
                            System.out.println("VENTANA IZQUIERDA FILA "+(jpri+1));
                            break;
                        case 1:
                            System.out.println("PASILLO IZQUIERDO FILA "+(jpri+1));
                            break;
                        case 2:
                            System.out.println("CENTRO IZQUIERDO FILA "+(jpri+1));
                            break;
                        case 3:
                            System.out.println("CENTRO DERECHO FILA "+(jpri+1));
                            break;                   
                        case 4:
                            System.out.println("PASILLO DERECHO FILA "+(jpri+1));
                            break;
                        case 5:
                            System.out.println("VENTANA DERECHA FILA "+(jpri+1));                          
                            break;
                        default:
                            break;
                    }
                    fContarEc();
                    i=50;
                }
               
            }
        }
       if(Select==true){
           System.out.println("NO SE ENCUENTRA");
           Select=false;
       }
    }
        
    }
        
    public static void main(String[] args) {
         VaciarSi();
         VaciarSiEc();
         funcionpedir();
         fEscogerClase();
         fWindow();
         
        System.out.println("YA");
        System.out.println(AeropuertoGestion1.auxnombre);
    }
    
}