import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainCreacion {

	public static void main(String[] args) {
		
		
		Tienda t1 = new Tienda(1,"CENTRAL", "600100100");
		Tienda t2 = new Tienda(2,"SUCURSAL1", "600100200");
		Tienda t3 = new Tienda(3,"SUCURSAL2", null); 
		//
		Familia f1 = new Familia("CAMARA", "C�maras digitales");
		Familia f2 = new Familia("CONSOL", "Consolas");
		Familia f3 = new Familia("EBOOK", "Libros electr�nicos");
		Familia f4 = new Familia("IMPRES", "Impresoras");
		Familia f5 = new Familia("MEMFLA", "Memorias flash");
		Familia f6 = new Familia("MP3", "Reproductores MP3");
		Familia f7 = new Familia("MULTIF", "Equipos multifunci�n");
		Familia f8 = new Familia("NETBOK", "Netbooks");
		Familia f9 = new Familia("ORDENA", "Ordenadores");
		Familia f10 = new Familia("PORTAT", "Ordenadores port�tiles");
		Familia f11 = new Familia("ROUTER", "Routers");
		Familia f12 = new Familia("SAI", "Sistemas de alimentaci�n ininterrumpida");
		Familia f13= new Familia("SOFTWA", "Software");
		Familia f14 = new Familia("TV", "Televisores");
		Familia f15 = new Familia("VIDEOC", "Videoc�maras");
		//
		//	
		Producto p1 = new Producto("3DSNG", null, "Nintendo 3DS negro", "Nintendo 3DS negro', 'Consola port�til de Nintendo que permitir� disfrutar de efectos 3D sin necesidad de gafas especiales, e incluir� retrocompatibilidad con el software de DS y de DSi.", 270.00, f2);
		Producto p2 = new Producto("ACERAX3950", null, "Acer AX3950 I5-650 4GB 1TB W7HP", "Caracter�sticas:\\r\\n\\r\\nSistema Operativo : Windows� 7 Home Premium Original\\r\\n\\r\\nProcesador / Chipset\\r\\nN�mero de Ranuras PCI: 1\\r\\nFabricante de Procesador: Intel\\r\\nTipo de Procesador: Core i5\\r\\nModelo de Procesador: i5-650\\r\\nN�cleo de Procesador: Dual-core\\r\\nVelocidad de Procesador: 3,20 GHz\\r\\nCach�: 4 MB\\r\\nVelocidad de Bus: No aplicable\\r\\nVelocidad HyperTransport: No aplicable\\r\\nInterconexi�n QuickPathNo aplicable\\r\\nProcesamiento de 64 bits: S�\\r\\nHyper-ThreadingS�\\r\\nFabricante de Chipset: Intel\\r\\nModelo de Chipset: H57 Express\\r\\n\\r\\nMemoria\\r\\nMemoria Est�ndar: 4 GB\\r\\nMemoria M�xima: 8 GB\\r\\nTecnolog�a de la Memoria: DDR3 SDRAM\\r\\nEst�ndar de Memoria: DDR3-1333/PC3-10600\\r\\nN�mero de Ranuras de Memoria (Total): 4\\r\\nLector de tarjeta memoria: S�\\r\\nSoporte de Tarjeta de Memoria: Tarjeta CompactFlash (CF)\\r\\nSoporte de Tarjeta de Memoria: MultiMediaCard (MMC)\\r\\nSoporte de Tarjeta de Memoria: Micro Drive\\r\\nSoporte de Tarjeta de Memoria: Memory Stick PRO\\r\\nSoporte de Tarjeta de Memoria: Memory Stick\\r\\nSoporte de Tarjeta de Memoria: CF+\\r\\nSoporte de Tarjeta de Memoria: Tarjeta Secure Digital (SD)\\r\\n\\r\\nStorage\\r\\nCapcidad Total del Disco Duro: 1 TB\\r\\nRPM de Disco Duro: 5400\\r\\nTipo de Unidad �ptica: Grabadora DVD\\r\\nCompatibilidad de Dispositivo �ptico: DVD-RAM/�R/�RW\\r\\nCompatibilidad de Medios de Doble Capa: S�", 410.00, f9);
		Producto p3 = new Producto("ARCLPMP32GBN", null, "Archos Clipper MP3 2GB negro", "Caracter�sticas:\\r\\n\\r\\nAlmacenamiento Interno Disponible en 2 GB*\\r\\nCompatibilidad Windows o Mac y Linux (con soporte para almacenamiento masivo)\\r\\nInterfaz para ordenador USB 2.0 de alta velocidad\\r\\nBatter�a2 11 horas m�sica\\r\\nReproducci�n M�sica3 MP3\\r\\nMedidas Dimensiones: 52mm x 27mm x 12mm, Peso: 14 Gr", 26.70, f6);
		Producto p4 = new Producto("BRAVIA2BX400", null, "Sony Bravia 32IN FULLHD KDL-32BX400", "Caracter�sticas:\\r\\n\\r\\nFull HD: Vea deportes pel�culas y juegos con magn�ficos detalles en alta resoluci�n gracias a la resoluci�n 1920x1080.\\r\\n\\r\\nHDMI�: 4 entradas (3 en la parte posterior, 1 en el lateral)\\r\\n\\r\\nUSB Media Player: Disfrute de pel�culas, fotos y m�sica en el televisor.\\r\\n\\r\\nSintonizador de TV HD MPEG-4 AVC integrado: olv�dese del codificador y acceda a servicios de TV que incluyen canales HD con el sintonizador DVB-T y DVB-C integrado con decodificador MPEG4 AVC (dependiendo del pa�s y s�lo con operadores compatibles)\\r\\n\\r\\nSensor de luz: ajusta autom�ticamente el brillo seg�n el nivel de la iluminaci�n ambiental para que pueda disfrutar de una calidad de imagen �ptima sin consumo innecesario de energ�a.\\r\\n\\r\\nBRAVIA Sync: controle su sistema de ocio dom�stico entero con un mismo mando a distancia universal que le permite reproducir contenidos o ajustar la configuraci�n de los dispositivos compatibles con un solo bot�n.\\r\\n\\r\\nBRAVIA ENGINE 2: experimente colores y detalles de imagen incre�blemente n�tidos y definidos. \\r\\n\\r\\nLive Colour�: seleccione entre cuatro modos: desactivado, bajo, medio y alto, para ajustar el color y obtener im�genes vivas y una calidad �ptima. \\r\\n\\r\\n24p True Cinema�: reproduzca una aut�ntica experiencia cinem�tica y disfrute de pel�culas exactamente como el director las concibi� a 24 fotogramas por segundo.", 356.90, f14);
		Producto p5 = new Producto("EEEPC1005PXD", null,"Asus EEEPC 1005PXD N455 1 250 BL", "Caracter�sticas:\\r\\nProcesador: 1660 MHz, N455, Intel Atom, 0.5 MB. \\r\\nMemoria: 1024 MB, 2 GB, DDR3, SO-DIMM, 1 x 1024 MB. \\r\\nAccionamiento de disco: 2.5 \", 250 GB, 5400 RPM, \\r\\nSerial ATA, Serial ATA II, 250 GB. \\r\\nMedios de almacenaje: MMC, SD, SDHC. \\r\\nExhibici�n: 10.1 \", 1024 x 600 Pixeles, LCD TFT. \\r\\nC�mara fotogr�fica: 0.3 MP. \\r\\nRed: 802.11 b/g/n, 10, 100 Mbit/s, \\r\\nFast Ethernet. \\r\\nAudio: HD. \\r\\nSistema operativo/software: Windows 7 Starter. \\r\\nColor: Blanco. \\r\\nContro de energ�a: 8 MB/s, Litio-Ion, 6 piezas, 2200 mAh, 48 W. \\r\\nPeso y dimensiones: 1270 g, 178 mm, 262 mm, 25.9 mm, 36.5 mm", 245.40, f8);
		Producto p6 = new Producto("HPMIN1103120", null, "HP Mini 110-3120 10.1LED N455 1GB 250GB W7S negro", "Caracter�sticas:\\r\\nSistema operativo instalado \\r\\nWindows� 7 Starter original 32 bits \\r\\n\\r\\nProcesador \\r\\nProcesador Intel� Atom� N4551,66 GHz, Cache de nivel 2, 512 KB \\r\\n\\r\\nChipset NM10 Intel� + ICH8m \\r\\n\\r\\nMemoria \\r\\nDDR2 de 1 GB (1 x 1024 MB) \\r\\nMemoria m�xima \\r\\nAdmite un m�ximo de 2 GB de memoria DDR2 \\r\\n\\r\\nRanuras de memoria \\r\\n1 ranura de memoria accesible de usuario \\r\\n\\r\\nUnidades internas \\r\\nDisco duro SATA de 250 GB (5400 rpm) \\r\\n\\r\\nGr�ficos \\r\\nTama�o de pantalla (diagonal) \\r\\nPantalla WSVGA LED HP Antirreflejos de 25,6 cm (10,1\") en diagonal \\r\\n\\r\\nResoluci�n de la pantalla \\r\\n1024 x 600", 270.00, f8);
		Producto p7 = new Producto("IXUS115HSAZ", null, "Canon Ixus 115HS azul", "Caracter�sticas:\\r\\nHS System (12,1 MP) \\r\\nZoom 4x, 28 mm. IS �ptico \\r\\nCuerpo met�lico estilizado \\r\\nPantalla LCD PureColor II G de 7,6 cm (3,0\") \\r\\nFull HD. IS Din�mico. HDMI \\r\\nModo Smart Auto (32 escenas) ", 196.70, f1);
		Producto p8 = new Producto("KSTDT101G2", null, "Kingston DataTraveler 16GB DT101G2 USB2.0 negro", "Caracter�sticas:\\r\\nCapacidades � 16GB\\r\\nDimensiones � 2.19\" x 0.68\" x 0.36\" (55.65mm x 17.3mm x 9.05mm)\\r\\nTemperatura de Operaci�n � 0� hasta 60� C / 32� hasta 140� F\\r\\nTemperatura de Almacenamiento � -20� hasta 85� C / -4� hasta 185� F\\r\\nSimple � Solo debe conectarlo a un puerto USB y est� listo para ser utilizado\\r\\nPractico � Su dise�o sin tapa giratorio, protege el conector USB; sin tapa que perder\\r\\nGarantizado � Cinco a�os de garant�a", 19.20, f5);
		Producto p9 = new Producto("KSTDTG332GBR", null, "Kingston DataTraveler G3 32GB rojo", "Caracter�sticas:\\r\\n\\r\\nTipo de producto Unidad flash USB\\r\\nCapacidad almacenamiento32GB\\r\\nAnchura 58.3 mm\\r\\nProfundidad 23.6 mm\\r\\nAltura 9.0 mm\\r\\nPeso 12 g\\r\\nColor incluido RED\\r\\nTipo de interfaz USB", 40.00, f5);
		Producto p10 = new Producto("KSTMSDHC8GB", null, "Kingston MicroSDHC 8GB", "Kingston tarjeta de memoria flash 8 GB microSDHC\\r\\n�ndice de velocidad    Class 4\\r\\nCapacidad almacenamiento    8 GB\\r\\nFactor de forma  MicroSDHC\\r\\nAdaptador de memoria incluido   Adaptador microSDHC a SD\\r\\nGarant�a del fabricante   Garant�a limitada de por vida", 10.20, f5);
		Producto p11 = new Producto("LEGRIAFS306", null, "Canon Legria FS306 plata", "Caracter�sticas:\\r\\n\\r\\nGrabaci�n en tarjeta de memoria SD/SDHC \\r\\nLa c�mara de v�deo digital de Canon m�s peque�a nunca vista \\r\\nInstant�nea de V�deo (Video Snapshot) \\r\\nZoom Avanzado de 41x \\r\\nGrabaci�n Dual (Dual Shot) \\r\\nEstabilizador de la Imagen con Modo Din�mico \\r\\nPre grabaci�n (Pre REC) \\r\\nSistema 16:9 de alta resoluci�n realmente panor�mico \\r\\nBater�a inteligente y Carga R�pida \\r\\nCompatible con grabador de DVD DW-100 \\r\\nSISTEMA DE V�DEO\\r\\nSoporte de grabaci�n: Tarjeta de memoria extra�ble (SD/SDHC)\\r\\nTiempo m�ximo de grabaci�n: Variable, dependiendo del tama�o de la tarjeta de memoria.\\r\\nTarjeta SDHC de 32 GB: 20 horas 50 minutos", 175.00, f15);
		Producto p12 = new Producto("LGM237WDP", null, "LG TDT HD 23 M237WDP-PC FULL HD", "Caracter�sticas:\\r\\n\\r\\nGeneral\\r\\nTama�o (pulgadas): 23\\r\\nPantalla LCD: S�\\r\\nFormato: 16:9\\r\\nResoluci�n: 1920 x 1080\\r\\nFull HD: S�\\r\\nBrillo (cd/m2): 300\\r\\nRatio Contraste: 50.000:1\\r\\nTiempo Respuesta (ms): 5\\r\\n�ngulo Visi�n (�): 170\\r\\nN�mero Colores (Millones): 16.7\\r\\n\\r\\nTV\\r\\nTDT: TDT HD\\r\\nConexiones\\r\\nD-Sub: S�\\r\\nDVI-D: S�\\r\\nHDMI: S�\\r\\nEuroconector: S�\\r\\nSalida auriculares: S�\\r\\nEntrada audio: S�\\r\\nUSB Servicio: S�\\r\\nRS-232C Servicio: S�\\r\\nPCMCIA: S�\\r\\nSalida �ptico: S�", 186.00, f14);
		Producto p13 = new Producto("LJPROP1102W", null,"HP Laserjet Pro Wifi P1102W" , "Caracter�sticas:\\r\\n\\r\\nGeneral\\r\\nTama�o (pulgadas): 23\\r\\nPantalla LCD: S�\\r\\nFormato: 16:9\\r\\nResoluci�n: 1920 x 1080\\r\\nFull HD: S�\\r\\nBrillo (cd/m2): 300\\r\\nRatio Contraste: 50.000:1\\r\\nTiempo Respuesta (ms): 5\\r\\n�ngulo Visi�n (�): 170\\r\\nN�mero Colores (Millones): 16.7\\r\\n\\r\\nTV\\r\\nTDT: TDT HD\\r\\nConexiones\\r\\nD-Sub: S�\\r\\nDVI-D: S�\\r\\nHDMI: S�\\r\\nEuroconector: S�\\r\\nSalida auriculares: S�\\r\\nEntrada audio: S�\\r\\nUSB Servicio: S�\\r\\nRS-232C Servicio: S�\\r\\nPCMCIA: S�\\r\\nSalida �ptico: S�", 99.90, f4);
		Producto p14 = new Producto("OPTIOLS1100", null, "Pentax Optio LS1100", "La LS1100 con funda de transporte y tarjeta de memoria de 2GB incluidas \\r\\nes la compacta digital que te llevar�s a todas partes. \\r\\nEsta c�mara dise�ada por Pentax incorpora un sensor CCD de 14,1 megap�xeles y un objetivo gran angular de 28 mm.\\r\\n", 104.80, f1);
		Producto p15 = new Producto("PAPYRE62GB", null, "Lector ebooks Papyre6 con SD2GB + 500 ebooks", "Marca Papyre \\r\\nModelo Papyre 6.1 \\r\\nUso Lector de libros electr�nicos \\r\\nTecnolog�a e-ink (tinta electr�nica, Vizplez) \\r\\nCPU Samsung Am9 200MHz \\r\\nMemoria - Interna: 512MB \\r\\n- Externa: SD/SDHC (hasta 32GB) \\r\\nFormatos PDF, RTF, TXT, DOC, HTML, MP3, CHM, ZIP, FB2, Formatos de imagen \\r\\nPantalla 6\" (600x800px), blanco y negro, 4 niveles de grises", 205.50, f3);
		Producto p16 = new Producto("PBELLI810323", null, "Packard Bell I8103 23 I3-550 4G 640GB NVIDIAG210", "Caracter�sticas:\\r\\n\\r\\nCPU CHIPSET\\r\\n\\r\\nProcesador : Ci3-550\\r\\nNorthBridge : Intel H57\\r\\n\\r\\nMEMORIA\\r\\nMemoria Rma : Ddr3 4096 MB\\r\\n\\r\\nDISPOSITIVOS DE ALMACENAMIENTO\\r\\nDisco Duro: 640Gb 7200 rpm\\r\\n�ptico : Slot Load siper multi Dvdrw\\r\\nLector de Tarjetas: 4 in 1 (XD, SD, HC, MS, MS PRO, MMC)\\r\\n\\r\\ndispositivos gr�ficos\\r\\nMonitor: 23 fHD\\r\\nTarjeta Gr�fica: Nvidia G210M D3 512Mb\\r\\nMemoria M�xima: Hasta 1918Mb\\r\\n\\r\\nAUDIO\\r\\nAudio Out: 5.1 Audio Out\\r\\nAudio In: 1 jack\\r\\nHeasphone in: 1x jack\\r\\nAltavoces: Stereo\\r\\n\\r\\nACCESORIOS\\r\\nTeclado: Teclado y rat�n inal�mbrico\\r\\nMando a distancia: EMEA Win7 WMC\\r\\n\\r\\n\\r\\nCOMUNICACIONES\\r\\nWireless: 802.11 b/g/n mini card \\r\\nTarjeta de Red: 10/100/1000 Mbps\\r\\nBluetooth: Bluethoot\\r\\nWebcam: 1Mpixel Hd (1280x720)\\r\\nTv tuner: mCARD/SW/ DVB-T\\r\\n\\r\\nMONITOR\\r\\nTama�o: 23\"\\r\\ncontraste: 1000:1\\r\\nTiempo de respuesta: 5MS\\r\\nResoluci�n: 1920 X 1080\\r\\n\\r\\nPUERTOS E/S\\r\\nUsb 2.0 : 6\\r\\nMini Pci-e : 2\\r\\nEsata: 1\\r\\n\\r\\nSISTEMA OPERATIVO\\r\\nO.S: Microsoft Windows 7 Premium", 761.80, f9);
		Producto p17 = new Producto("PIXMAIP4850", null, "Canon Pixma IP4850", "Caracter�sticas:\\r\\n\\r\\nTipo: chorro de tinta cartuchos independientes\\r\\nConexi�n: Hi-Speed USB\\r\\nPuerto de impresi�n directa desde camaras\\r\\nResoluci�n m�xima: 9600x2400 ppp\\r\\nVelocidad impresi�n: 11 ipm (negro) / 9.3 ipm (color)\\r\\nTama�o m�ximo papel: A4\\r\\nBandeja entrada: 150 hojas\\r\\nDimensiones: 43.1 cm x 29.7 cm x 15.3 cm", 97.30, f4);
		Producto p18 = new Producto("PIXMAMP252", null, "Canon Pixma MP252", "Caracter�sticas:\\r\\n\\r\\nFunciones: Impresora, Esc�ner , Copiadora\\r\\nConexi�n: USB 2.0\\r\\nDimensiones:444 x 331 x 155 mm\\r\\nPeso: 5,8 Kg\\r\\n\\r\\nIMPRESORA\\r\\nResoluci�n m�xima: 4800 x 1200 ppp\\r\\nVelocidad de impresi�n:\\r\\nNegro/color: 7,0 ipm / 4,8 ipm\\r\\nTama�o m�ximo papel: A4\\r\\nCARTUCHOS\\r\\nNegro: PG-510 / PG-512\\r\\nColor: CL-511 / CL-513\\r\\n\\r\\nESCANER\\r\\nResoluci�n m�xima: 600 x 1200 ppp (digital: 19200 x 19200)\\r\\nProfundidad de color: 48/24 bits\\r\\nArea m�xima de escaneado: A4\\r\\n\\r\\nCOPIA\\r\\nTiempo salida 1� copia: aprox 39 seg.", 41.60, f7);
		Producto p19 = new Producto("PS3320GB", null, "PS3 con disco duro de 320GB", "Este Pack Incluye:\\r\\n- La consola Playstation 3 Slim Negra 320GB\\r\\n- El juego Killzone 3\\r\\n", 380.00, f2);
		Producto p20 = new Producto("PWSHTA3100PT", null, "Canon Powershot A3100 plata", "La c�mara PowerShot A3100 IS, inteligente y compacta, presenta la calidad de imagen de Canon en un cuerpo\\r\\ncompacto y ligero para capturar fotograf�as sin esfuerzo; es tan f�cil como apuntar y disparar.\\r\\nCaracter�sticas:\\r\\n12,1 MP \\r\\nZoom �ptico 4x con IS \\r\\nPantalla LCD de 6,7 cm (2,7\") ", 101.40, f1);
		Producto p21 = new Producto("SMSGCLX3175", null, "Samsung CLX3175", "Caracter�sticas:\\r\\n\\r\\nFunci�n: Impresi�n color, copiadora, esc�ner\\r\\nImpresi�n \\r\\nVelocidad (Mono)Hasta 16 ppm en A4 (17 ppm en Carta)\\r\\nVelocidad (Color)Hasta 4 ppm en A4 (4 ppm en Carta)\\r\\nSalida de la Primer P�gina (Mono)Menos de 14 segundos (Desde el Modo Listo)\\r\\nResoluci�nHasta 2400 x 600 dpi de salida efectiva\\r\\nSalida de la Primer P�gina (Color)Menos de 26 segundos (Dese el Modo Listo)\\r\\nDuplexManual\\r\\nEmulaci�nSPL-C (Lenguaje de color de impresi�n SAMSUNG)\\r\\n\\r\\nCopiado \\r\\nSalida de la Primer P�gina (Mono)18 segundos\\r\\nMulticopiado1 ~ 99\\r\\nZoom25 ~ 400 %\\r\\nFunciones de CopiadoCopia ID, Clonar Copia, Copia N-UP, Copiar Poster\\r\\nResoluci�nTexto, Texto / Foto, Modo Revista: hasta 600 x 600 ppp, Modo Foto: Hasta 1200 x 1200 ppp\\r\\nVelocidad (Mono)Hasta 17 ppm en Carta (16 ppm en A4)\\r\\nVelocidad (Color)Hasta 4 ppm en Carta (4 ppm en A4 )\\r\\nSalida de la Primer P�gina (Color)45 segundos\\r\\n\\r\\nEscaneado \\r\\n\\r\\nCompatibilidadNorma TWAIN, Norma WIA (Windows2003 / XP / Vista)\\r\\nM�todoEsc�ner plano color\\r\\nResoluci�n (�ptica)1200 x 1200 dpi\\r\\nResoluci�n (Mejorada)4800 x 4800 dpi\\r\\nEscaneado a Escanear a USB / Carpeta", 190.00, f7);
		Producto p22 = new Producto("SMSN150101LD", null, "Samsung N150 10.1LED N450 1GB 250GB BAT6 BT W7 R", "Caracter�sticas:\\r\\n\\r\\nSistema Operativo Genuine Windows� 7 Starter \\r\\n\\r\\nProcesador Intel� ATOM Processor N450 (1.66GHz, 667MHz, 512KB) \\r\\n\\r\\nChipset Intel� NM10\\r\\n\\r\\nMemoria del Sistema 1GB (DDR2 / 1GB x 1) Ranura de Memoria 1 x SODIMM \\r\\n\\r\\nPantalla LCD 10.1\" WSVGA (1024 x 600), Non-Gloss, LED Back Light Gr�ficos \\r\\n\\r\\nProcesador Gr�fico Intel� GMA 3150 DVMT \\r\\nMemoria Gr�fica Shared Memory (Int. Grahpic) \\r\\n\\r\\nMultimedia \\r\\nSonido HD (High Definition) Audio \\r\\nCaracter�sticas de Sonido SRS 3D Sound Effect \\r\\nAltavoces 3W Stereo Speakers (1.5W x 2) \\r\\nC�mara Integrada Web Camera \\r\\n\\r\\nAlmacenamiento \\r\\nDisco duro 250GB SATA (5400 rpm S-ATA) \\r\\n\\r\\nConectividad\\r\\nWired Ethernet LAN (RJ45) 10/100 LAN \\r\\nWireless LAN 802.11 b/g/N\\r\\n\\r\\nBluetooth Bluetooth 3.0 High Speed \\r\\n\\r\\nI/O Port \\r\\nVGA \\r\\nHeadphone-out\\r\\nMic-in\\r\\nInternal Mic\\r\\nUSB (Chargable USB included) 3 x USB 2.0 \\r\\nMulti Card Slot 4-in-1 (SD, SDHC, SDXC, MMC)\\r\\nDC-in (Power Port)\\r\\n\\r\\nTipo de Teclado 84 keys \\r\\nTouch Pad, Touch Screen Touch Pad (Scroll Scope, Flat Type) \\r\\n\\r\\nSeguridad\\r\\nRecovery Samsung Recovery Solution \\r\\nVirus McAfee Virus Scan (trial version) \\r\\nSeguridad BIOS Boot Up Password / HDD Password \\r\\nBloqueo Kensington Lock Port \\r\\n\\r\\nBater�a \\r\\nAdaptador 40 Watt Bater�a \\r\\n6 Cell Dimensiones", 260.60, f8);
		Producto p23 = new Producto("SMSSMXC200PB", null, "Samsung SMX-C200PB EDC ZOOM 10X", "Caracter�sticas:\\r\\n\\r\\nSensor de Imagen Tipo 1 / 6� 800K pixel CCD\\r\\n\\r\\nLente Zoom �ptico 10 x optico\\r\\n\\r\\nCaracter�sticas Grabaci�n V�deo Estabilizador de Imagen Hiper estabilizador de imagen digital\\r\\n\\r\\nInterfaz Tarjeta de Memoria Ranura de Tarjeta SDHC / SD", 127.20, f15);
		Producto p24 = new Producto("STYLUSSX515W", null, "Epson Stylus SX515W", "Caracter�sticas:\\r\\n\\r\\nResoluci�n m�xima5760 x 1440 DPI\\r\\nVelocidad de la impresi�n\\r\\nVelocidad de impresi�n (negro, calidad normal, A4)36 ppm\\r\\nVelocidad de impresi�n (color, calidad normal, A4)36 ppm\\r\\n\\r\\nTecnolog�a de la impresi�n\\r\\nTecnolog�a de impresi�n inyecci�n de tinta\\r\\nN�mero de cartuchos de impresi�n4 piezas\\r\\nCabeza de impresoraMicro Piezo\\r\\n\\r\\nExploraci�n\\r\\nResoluci�n m�xima de escaneado2400 x 2400 DPI\\r\\nEscaner color: si\\r\\nTipo de digitalizaci�n Esc�ner plano\\r\\nEscanaer integrado: si\\r\\nTecnolog�a de exploraci�n CIS\\r\\nWLAN, conexi�n: si", 77.50, f7);
		Producto p25 = new Producto("TSSD16GBC10J", null, "Toshiba SD16GB Class10 Jewel Case", "Caracter�sticas:\\r\\n\\r\\nDensidad: 16 GB\\r\\nPINs de conexi�n: 9 pins\\r\\nInterfaz: Tarjeta de memoria SD standard compatible\\r\\nVelocidad de Escritura: 20 MBytes/s* \\r\\nVelocidad de Lectura: 20 MBytes/s*\\r\\nDimensiones: 32.0 mm (L) � 24.0 mm (W) � 2.1 mm (H)\\r\\nPeso: 2g\\r\\nTemperatura: -25�C a +85�C (Recomendada)\\r\\nHumedad: 30% to 80% RH (sin condensaci�n)", 32.60, f5);
		Producto p26 = new Producto("ZENMP48GB300", null, "Creative Zen MP4 8GB Style 300", "Caracter�sticas:\\r\\n\\r\\n8 GB de capacidad\\r\\nAutonom�a: 32 horas con archivos MP3 a 128 kbps\\r\\nPantalla TFT de 1,8 pulgadas y 64.000 colores\\r\\nFormatos de audio compatibles: MP3, WMA (DRM9), formato Audible 4\\r\\nFormatos de foto compatibles: JPEG (BMP, TIFF, GIF y PNG\\r\\nFormatos de v�deo compatibles: AVI transcodificado (Motion JPEG)\\r\\nEcualizador de 5 bandas con 8 preajustes\\r\\nMicr�fono integrado para grabar voz\\r\\nAltavoz y radio FM incorporada", 58.90, f6);
		//
		Stock s1 = new Stock(p1, t1, 2);
		Stock s2 = new Stock(p1, t2, 1);
		Stock s3 = new Stock(p3, t2, 1);
		Stock s4= new Stock(p3, t3, 2);
		Stock s5 = new Stock(p4, t3, 1);
		Stock s6 = new Stock(p5, t1, 2);
		Stock s7 = new Stock(p5, t2, 1);
		Stock s8 = new Stock(p6, t2, 1);
		Stock s9 = new Stock(p6, t3, 2);
		Stock s10 = new Stock(p7, t2, 2);
		Stock s11 = new Stock(p8, t3, 1);
		Stock s12 = new Stock(p9, t2, 2);
		Stock s13 = new Stock(p10, t1, 1);
		Stock s14 = new Stock(p10, t2, 2);
		Stock s15 = new Stock(p10, t3, 2);
		Stock s16 = new Stock(p11, t2, 1);
		Stock s17 = new Stock(p12, t1, 1);
		Stock s18 = new Stock(p13, t2, 2);
		Stock s19 = new Stock(p14, t1, 3);
		Stock s20 = new Stock(p14, t2, 1);
		Stock s21 = new Stock(p15, t1, 2);
		Stock s22 = new Stock(p15, t3, 1);
		Stock s23 = new Stock(p16, t2, 1);
		Stock s24 = new Stock(p17, t2, 1);
		Stock s25 = new Stock(p17, t3, 2);
		Stock s26 = new Stock(p18, t2, 1);
		Stock s27 = new Stock(p19, t1, 1);
		Stock s28 = new Stock(p20, t2, 2);
		Stock s29 = new Stock(p20, t3, 2);
		Stock s30 = new Stock(p21, t2, 1);
		Stock s31 = new Stock(p22, t3, 1);
		Stock s32 = new Stock(p23, t2, 1);
		Stock s33 = new Stock(p24, t1, 1);
		Stock s34 = new Stock(p25, t3, 2);
		Stock s35 = new Stock(p26, t1, 3);
		Stock s36 = new Stock(p26, t2, 2);
		Stock s37 = new Stock(p26, t3, 2);
		
	
		
		//-----------------------------------------------------------------
		EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("db/gestionStock.odb");
	   EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
      //
       em.persist(t1); em.persist(t2);em.persist(t3);
       //
       em.persist(f1);em.persist(f2);em.persist(f3);em.persist(f4);em.persist(f5);em.persist(f6);em.persist(f7);
       em.persist(f8);em.persist(f9);em.persist(f10);em.persist(f11);em.persist(f12);em.persist(f13);em.persist(f14);em.persist(f15);
       //
       em.persist(p1);em.persist(p2);em.persist(p3);em.persist(p4);em.persist(p5);em.persist(p6);em.persist(p7);em.persist(p8);em.persist(p9);
       em.persist(p10);em.persist(p11);em.persist(p12);em.persist(p13);em.persist(p14);em.persist(p15);em.persist(p16);em.persist(p17);
       em.persist(p18);em.persist(p19);em.persist(p20);em.persist(p21);em.persist(p22);em.persist(p23);em.persist(p24);em.persist(p25);em.persist(p26);
       //  
       em.persist(s1);em.persist(s2);em.persist(s3);em.persist(s4);em.persist(s5);em.persist(s6);em.persist(s7);em.persist(s8);em.persist(s9);
       em.persist(s10);em.persist(s11);em.persist(s12);em.persist(s13);em.persist(s14);em.persist(s15);em.persist(s16);em.persist(s17);
       em.persist(s18);em.persist(s19);em.persist(s20);em.persist(s21);em.persist(s22);em.persist(s23);em.persist(s24);em.persist(s25);em.persist(s26);
       em.persist(s27);em.persist(s28);em.persist(s29);em.persist(s30);em.persist(s31);em.persist(s32);em.persist(s33);em.persist(s34);em.persist(s35);
       em.persist(s36);em.persist(s37);
       
       //       
       em.getTransaction().commit();
       em.close();
       emf.close();

	}

}
