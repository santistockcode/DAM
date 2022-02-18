

public class MusicoEstudiante implements Musico,Estudiante {
@Override
	public void hablar() {
	System.out.println("hablo");
}
@Override
public void tocarMusica() {
	System.out.println("toco");
}

@Override
public void estudiar() {
	System.out.println("estudio");
}
}
