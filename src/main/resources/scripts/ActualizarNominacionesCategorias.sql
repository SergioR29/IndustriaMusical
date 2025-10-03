SET SERVEROUTPUT ON;

DECLARE
    CURSOR CATEGORIAS_ORDENADAS IS
        SELECT C.ID FROM CATEGORIAS C;
    
    CURSOR CATEGORIAS_NOMINACIONES IS
        SELECT N.ID, N.ID_CATEGORIA, N.ID_CANCION FROM NOMINACIONES N;
        
    CN CANCIONES_NOMINADAS := CANCIONES_NOMINADAS();
    NM NOMINACION;
    
    NOMINADAS NUMBER;
    ID_CAT NUMBER;
BEGIN
    NOMINADAS := 0;
    FOR CAT IN CATEGORIAS_ORDENADAS LOOP
        ID_CAT := CAT.ID;
        
        FOR I IN CATEGORIAS_NOMINACIONES LOOP
            IF ID_CAT = I.ID_CATEGORIA THEN
                NM := NOMINACION(I.ID, I.ID_CATEGORIA, I.ID_CANCION);
                NOMINADAS := NOMINADAS + 1;
                
                IF NOMINADAS <= 3 THEN
                    CN.EXTEND;
                    CN(CN.LAST) := NM;
                    
                    UPDATE CATEGORIAS C SET C.NOMINADAS = CN WHERE C.ID = ID_CAT;
                    COMMIT;
                ELSE
                    CN := CANCIONES_NOMINADAS();
                    NOMINADAS := 0;
                END IF;
            END IF;
        END LOOP;
    END LOOP;
END;