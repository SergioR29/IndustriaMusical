SET SERVEROUTPUT ON;

DECLARE
  CURSOR cancion_cursor IS
    SELECT C.TITULO, C.ID_ARTISTA, C.LETRA, C.ID_ALBUM, C.SINGLE, C.DURACION, C.COLABORADOR
    FROM CANCIONES C;

  CURSOR albumes_IDs IS
    SELECT A.ID FROM ALBUMES A;

    canciones_album_ CANCIONES_ALBUM := CANCIONES_ALBUM();
    v_cancion CANCION;
BEGIN
  FOR alb IN albumes_IDs LOOP
    FOR cant IN cancion_cursor LOOP
        IF alb.ID = cant.ID_ALBUM THEN
            v_cancion := CANCION(cant.TITULO, cant.ID_ARTISTA, cant.LETRA, cant.ID_ALBUM, cant.SINGLE, cant.DURACION, cant.COLABORADOR);
            canciones_album_.EXTEND;
            canciones_album_(canciones_album_.LAST) := v_cancion;
        END IF;
    END LOOP;
    
    UPDATE ALBUMES
    SET CANCIONES_ALB = canciones_album_
    WHERE ID = alb.ID;
    
    canciones_album_ := CANCIONES_ALBUM();
  END LOOP;
END;
/
