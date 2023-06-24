package quotespractical;

public class Quotes {

	public static void main(String[] args) {
		Quotes quote = new Quotes();

		quote.shakespearsQuote();
		quote.churchillQuote();
		quote.oscarWildeQuote();
		quote.georgeWBushQuote();
		quote.albertEinstein();
	}

	public void albertEinstein() {
		System.out.println("if the facts don't fit the theory, change the facts. Albert Einstein");
	}
	public void shakespearsQuote() {
		System.out.println("Good night, good night! Parting is such sweet sorrow, that i shall say good night till it be morrow. Shakespeare\n\n");
	}
	public void oscarWildeQuote() {
		System.out.println("Experience is simply the name we give our mistakes. Wilde\n\n");
	}
	public void churchillQuote() {
		System.out.println("Continuous effort - not strength or intelligence - is the key to unlocking our potential. Churchill\n\n");
	}
	public void georgeWBushQuote() {
		System.out.println("One of the great things about books is sometimes there are some fantastic pictures. George W Bush\n\n");
	}
}
