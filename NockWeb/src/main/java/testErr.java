public class testErr {

	public static void main(String[] args) {
		/*
		 * //numCheckの確認
		String arata = "123";
		int kakaku = 456;
		check_1(arata, kakaku);
		
		arata = "12a";
		kakaku = 456;
		check_1(arata, kakaku);
		
		arata = "-12";
		//kakaku = 456;
		check_1(arata, kakaku);
		
		arata = "123";
		kakaku = -45;
		check_1(arata, kakaku);
		
		*/
		
		/*
		//exitIdの確認
		String id = "11111";
		check_2(id);
		
		id = "00001";
		check_2(id);
		*/
		
		//notExitIdの確認
		String id = "12345";
		check_3(id);
		
		id = "00001";
		check_3(id);
	}
	
	//numCheckの確認用メソッド
	public static void check_1(String id, int kakaku) {
		Errcheck err = new Errcheck();
		
		String message;
		message = err.numCheck(id, kakaku);
		
		System.out.println(message);
	}
	
	//exitIdの確認用メソッド
	public static void check_2(String id) {
		Errcheck err = new Errcheck();
			
		String message;
			
		message = err.exitId(id);
			
		System.out.println(message);
	}
	
	//notExitIdの確認用メソッド
	public static void check_3(String id) 
	{
		Errcheck err = new Errcheck();
		
		String message;
		
		message = err.notExitId(id);
		
		System.out.println(message);
	}

}
