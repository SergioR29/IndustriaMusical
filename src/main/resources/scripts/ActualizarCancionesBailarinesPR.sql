SET SERVEROUTPUT ON;

DECLARE
    CURSOR PRESEN IS
        SELECT P.ID_PRESENTACION FROM PRESENTACIONES P;
        
    CURSOR CS_PRESEN IS
        SELECT CSP.ID, CSP.ID_PRESENTACION, CSP.CANCION_P FROM CS_PRESENTADAS CSP;
        
    CURSOR BLNS_PRESEN IS
        SELECT BP.ID, BP.ID_PRESENTACION, BP.ID_PERSONA FROM BAILARINES_PRESENTADOS BP;
        
    CPS CANCIONES_PRESENTADAS := CANCIONES_PRESENTADAS();
    BLS BAILARINES := BAILARINES();
    
    CP CANCION_PRESENTADA;
    BL BAILARIN;
    
    CPS_MAX NUMBER := 3;
    BLS_MAX NUMBER := 12;
    
    CPS_CONT NUMBER := 0;
    BLS_CONT NUMBER := 0;
BEGIN
    FOR P IN PRESEN LOOP
        FOR CN IN CS_PRESEN LOOP
            IF P.ID_PRESENTACION = CN.ID_PRESENTACION THEN
                CPS_CONT := CPS_CONT +1;
                CP := CANCION_PRESENTADA(CN.ID, CN.ID_PRESENTACION, CN.CANCION_P);
                
                IF CPS_CONT <= CPS_MAX THEN
                    CPS.EXTEND;
                    CPS(CPS.LAST) := CP;
                END IF;
            END IF;
        END LOOP;
        
        FOR BS IN BLNS_PRESEN LOOP
            IF P.ID_PRESENTACION = BS.ID_PRESENTACION THEN
                BLS_CONT := BLS_CONT +1;
                BL := BAILARIN(BS.ID, BS.ID_PRESENTACION, BS.ID_PERSONA);
                
                IF BLS_CONT <= BLS_MAX THEN
                    BLS.EXTEND;
                    BLS(BLS.LAST) := BL;
                END IF;
            END IF;
        END LOOP;
        
        UPDATE PRESENTACIONES PR SET PR.CANCIONES = CPS, PR.GRUPO_BAILE = BLS WHERE PR.ID_PRESENTACION = P.ID_PRESENTACION;
        COMMIT;
        
        CPS := CANCIONES_PRESENTADAS();
        BLS := BAILARINES();
        
        CPS_CONT := 0;
        BLS_CONT := 0;
        
    END LOOP;
END;