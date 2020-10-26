package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigStringBR {
	
	MethodsRep methodsRep = new MethodsRep();

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\joaqu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		// check confirmation text
		assertTrue("Submit was not sent",((driver.findElement(By.xpath("/html"))).getText()).contains("Informações enviadas com sucesso!"));
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		String bigString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed posuere metus lorem, ac lacinia neque mattis eget. Vestibulum feugiat elit eu rutrum interdum. Praesent faucibus congue gravida. Sed luctus in augue a commodo. In hendrerit consequat egestas. Etiam ac malesuada mauris. Curabitur eget sem vel metus condimentum pharetra non ac ligula. Nullam a sodales erat, nec fermentum lorem. Fusce varius lacus at lectus fringilla, et vestibulum risus laoreet.\r\n"
				+ "\r\n"
				+ "Maecenas sem est, pulvinar quis dignissim sit amet, condimentum ac ligula. Donec non accumsan tortor. Sed dictum mattis mauris non auctor. Vivamus fermentum diam mollis dapibus egestas. Donec rhoncus turpis ac libero dignissim commodo. Phasellus nec enim vulputate, tempus urna eu, aliquet justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas non dignissim augue. Integer faucibus a ex sit amet eleifend. Aliquam in nulla a odio porta commodo iaculis sed purus. Aliquam non nulla vulputate, dictum risus in, faucibus neque. Phasellus blandit a tortor non mattis. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n"
				+ "\r\n"
				+ "Duis ultricies venenatis tincidunt. Suspendisse tincidunt, justo quis suscipit lobortis, ligula eros maximus enim, et egestas elit erat ac tortor. Integer in laoreet nulla, eget convallis odio. Nunc eget urna interdum, porttitor justo quis, porta mi. In consectetur, metus sed scelerisque condimentum, sem tortor pellentesque ante, non cursus sapien metus aliquet arcu. Phasellus vestibulum, nisl non suscipit eleifend, erat odio laoreet lacus, eu pretium diam est eu libero. Duis id libero ac est fermentum hendrerit.\r\n"
				+ "\r\n"
				+ "Vivamus sollicitudin risus nec turpis porttitor, non tempus dui consectetur. Proin at condimentum sem. Etiam cursus, lorem sed sodales faucibus, ipsum neque porta nisi, vitae laoreet mauris nibh eu quam. Sed odio metus, congue sit amet risus in, hendrerit pretium turpis. Maecenas vitae velit purus. Sed maximus augue arcu. Ut pharetra blandit fermentum. Nam sit amet ante id erat sodales sagittis. Pellentesque ac dui quis purus semper tincidunt quis vulputate nisi. Donec vel justo nunc.\r\n"
				+ "\r\n"
				+ "Donec metus augue, aliquam ac magna ac, interdum condimentum sem. In interdum bibendum rhoncus. Integer hendrerit, lorem non aliquam dignissim, sem tellus ultricies turpis, in eleifend nulla massa ut diam. Nunc nec laoreet felis. Fusce nec maximus velit. Suspendisse pellentesque sagittis ex, vitae malesuada massa eleifend ac. Duis elit dolor, faucibus at lectus ut, vehicula cursus lorem. Maecenas a dui arcu.\r\n"
				+ "\r\n"
				+ "Pellentesque pretium vestibulum lectus ut mattis. Vivamus sapien nibh, vestibulum a lacinia vel, vulputate ac sem. Aliquam efficitur ligula iaculis vestibulum suscipit. Maecenas vel volutpat quam. Aenean porttitor tortor placerat risus ullamcorper tempor. Vestibulum consequat erat nisi, feugiat eleifend justo euismod malesuada. Aenean placerat nisl pellentesque, faucibus urna quis, commodo metus. Etiam vel aliquam dolor. Aenean eu varius massa. Aliquam laoreet enim quis justo accumsan, non aliquam mi aliquam. Suspendisse vulputate ligula sit amet interdum rutrum. Sed tellus nisi, euismod eu ultrices et, rhoncus vel lectus. Etiam molestie feugiat vestibulum. Mauris lacinia urna et metus dapibus consequat.\r\n"
				+ "\r\n"
				+ "Aenean id augue risus. Phasellus dignissim, felis ac imperdiet vehicula, dui augue tempor nulla, ac lacinia risus nisi a libero. Sed non ullamcorper diam. Quisque lobortis dolor id nisl pharetra interdum. Duis quis consectetur nunc. Quisque id risus varius, maximus felis non, consectetur turpis. Vivamus a enim placerat, lacinia dolor sit amet, tincidunt nisl. Curabitur blandit libero nec rhoncus faucibus. Sed a pulvinar ligula. Nam a scelerisque tortor. Donec rhoncus lobortis orci, eu ultrices ante luctus id. Curabitur egestas eleifend lorem in tincidunt.\r\n"
				+ "\r\n"
				+ "Quisque condimentum quam hendrerit iaculis porta. Nulla id leo purus. Integer consectetur nulla non sollicitudin dictum. Donec auctor sollicitudin viverra. Pellentesque nec lacus tincidunt, suscipit nisl quis, blandit dui. Integer efficitur rutrum nunc at facilisis. Aliquam quis suscipit sem, ac vehicula neque. Quisque pulvinar posuere imperdiet. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Ut urna ipsum, venenatis nec semper ac, sollicitudin et dolor. Aliquam semper quam eget elit consequat, ac hendrerit eros accumsan. Phasellus at pretium ipsum, posuere mollis eros. Duis risus diam, mattis eu tincidunt at, lobortis id lorem. Cras rutrum et risus sed varius. Sed ultricies massa lacinia suscipit suscipit. Etiam dui felis, auctor nec libero ut, porttitor pharetra purus.\r\n"
				+ "\r\n"
				+ "Proin ornare dapibus neque eu tempor. Pellentesque semper orci vitae urna luctus, quis malesuada orci ultricies. In varius nunc lectus, sit amet volutpat mi ultricies vel. Nullam malesuada mi ac quam viverra, non tempus lorem finibus. Pellentesque consectetur molestie ipsum, et convallis diam. Aenean et viverra neque. Donec gravida mi vel mi pellentesque commodo. In hac habitasse platea dictumst. Suspendisse potenti. Praesent eu justo mi. Donec odio nisi, tempor ut accumsan non, scelerisque at elit. Fusce semper viverra nibh. Ut euismod lectus nec varius efficitur. Vivamus eget tortor non turpis sollicitudin lacinia.\r\n"
				+ "\r\n"
				+ "Duis condimentum, tortor ut rhoncus ultricies, magna leo tristique elit, non venenatis dolor tortor mollis velit. Cras urna leo, ullamcorper ac sollicitudin at, vestibulum id turpis. Aenean dignissim diam mi, sed condimentum enim scelerisque fringilla. Morbi malesuada, felis at fermentum sodales, mauris dui feugiat turpis, ut pellentesque lectus justo sed justo. Nam ullamcorper a lorem vel dictum. Donec ac turpis eget turpis mattis gravida. In nec lobortis odio, nec faucibus nulla. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In cursus elementum tempus. Morbi et imperdiet nibh, vel sollicitudin metus. Ut convallis auctor elit, at congue velit bibendum at. Nunc sed ipsum non dolor ultricies porta. Curabitur sit amet quam a nunc mollis fermentum. Etiam ullamcorper hendrerit mauris, id sodales elit vestibulum at. Mauris ac nisi ligula. Aenean lobortis sollicitudin rhoncus.\r\n"
				+ "\r\n"
				+ "Sed blandit fermentum nisi nec mollis. Mauris commodo hendrerit erat. Donec at nulla accumsan, pharetra dolor vel, tristique sapien. In aliquam, arcu at volutpat pretium, diam diam convallis ligula, et placerat est sem vel urna. Donec vitae luctus eros, ac porta lorem. Sed vestibulum ligula vitae sem tristique placerat. Maecenas pretium lacinia ex, sit amet bibendum augue laoreet id. Donec faucibus luctus venenatis. Nulla fermentum finibus suscipit. Vestibulum ullamcorper molestie quam, elementum fermentum justo feugiat et. Aenean hendrerit ante vel semper porta. Suspendisse potenti. Nunc nec viverra magna. Pellentesque in quam vel sapien lobortis dapibus nec id mauris. Donec tempus consectetur mauris. Cras efficitur ex fermentum aliquam consequat.\r\n"
				+ "\r\n"
				+ "Proin libero ipsum, molestie sit amet mauris non, fringilla dapibus sapien. Nullam id turpis sapien. Donec mollis, urna eget tincidunt pellentesque, mi ipsum iaculis mauris, sed egestas lorem quam quis nulla. Vestibulum suscipit ante eu tortor molestie interdum. Nunc venenatis sed orci sit amet fermentum. Ut at mauris quis turpis pretium convallis nec at leo. Curabitur ornare neque et mauris facilisis vehicula. Phasellus rhoncus metus nec augue aliquam molestie. Vivamus dictum magna id lorem gravida ullamcorper. Maecenas sollicitudin leo a massa gravida ultrices.\r\n"
				+ "\r\n"
				+ "In nec vehicula purus. Aenean dolor felis, fermentum sit amet magna a, placerat tristique lectus. Aliquam semper, felis sit amet viverra porttitor, libero lacus iaculis massa, dictum semper orci risus et odio. Donec id sem id tortor aliquam auctor vel iaculis leo. Etiam congue eu metus sit amet euismod. Integer ultrices, metus et mattis feugiat, velit turpis posuere ligula, ac pulvinar sapien sapien ut ligula. Duis gravida nisi eu lectus pharetra commodo. Nulla malesuada diam vitae dolor tempor laoreet. Aliquam turpis nisi, cursus vitae erat ut, accumsan convallis felis. Phasellus tempor interdum sapien nec dignissim. In gravida hendrerit consequat. Nunc imperdiet maximus neque at pulvinar. Maecenas convallis lorem ipsum, at blandit quam pellentesque ut. Nam augue orci, tristique at turpis quis, laoreet interdum nulla. Cras porta fringilla tristique. Praesent et est ipsum.\r\n"
				+ "\r\n"
				+ "Ut lacus eros, viverra ac interdum vitae, lobortis ac neque. Aliquam neque ipsum, efficitur id malesuada vel, blandit a erat. Suspendisse lobortis urna vel vulputate vestibulum. Praesent iaculis imperdiet orci non suscipit. Mauris sit amet orci id tellus maximus cursus a non lorem. Curabitur dictum erat mauris, a tempor magna hendrerit id. Nulla facilisi. Morbi vel eros est. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam non mauris ligula. Nulla facilisi. Aliquam tortor risus, sagittis et elit sed, maximus dapibus mauris. Ut a tellus molestie neque pulvinar maximus sit amet a felis.\r\n"
				+ "\r\n"
				+ "Nunc in nulla scelerisque, pellentesque massa non, venenatis tellus. Phasellus vel finibus justo. Nulla maximus rhoncus tempor. Nam pellentesque ullamcorper velit nec vestibulum. Proin vehicula lacus est, ullamcorper accumsan ante finibus in. Ut condimentum, lectus sit amet suscipit gravida, sem mi pulvinar est, ut euismod nulla metus ut libero. Ut tincidunt lacinia ipsum, id porta turpis tempus ut. Duis et justo iaculis ligula vehicula mollis.\r\n"
				+ "\r\n"
				+ "Sed feugiat, felis eget aliquam vehicula, odio nisi faucibus turpis, bibendum euismod est ligula eget risus. In quis tortor lectus. Curabitur tincidunt purus non metus imperdiet, quis rutrum magna placerat. Integer pharetra dignissim ipsum. Maecenas et ex eget justo fringilla pharetra. Ut luctus interdum erat at convallis. Mauris nec ante nec massa dignissim tempor. Donec dictum neque ut turpis imperdiet dictum. Nam ac interdum augue. Aenean mattis felis sed turpis posuere tempus.\r\n"
				+ "\r\n"
				+ "Aliquam a maximus turpis. Praesent et elit neque. Sed in nulla egestas, egestas tellus ut, dignissim nulla. Donec in efficitur elit. Donec ut felis augue. Proin lobortis libero suscipit dolor tempus porttitor. Vestibulum a efficitur ante. Integer ut tristique nunc. Proin in feugiat eros.";

		// open site
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().window().maximize();
		
		//change to PT-BR
		methodsRep.changeLang(driver);
		driver.navigate().refresh();
		Thread.sleep(1000);

		methodsRep.fillName(bigString, driver);
		Thread.sleep(1000);
		methodsRep.fillDate(driver);
		Thread.sleep(1000);
		methodsRep.fillAnswer(bigString, driver);
		Thread.sleep(1000);
		methodsRep.submitForm(driver);

	}

}
