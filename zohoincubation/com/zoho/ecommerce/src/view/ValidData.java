package zohoincubation.com.zoho.ecommerce.src.view;

import java.util.Scanner;
import zohoincubation.com.zoho.ecommerce.src.interfaceController.IDataValidation;

public class ValidData implements IDataValidation {
	private final Scanner sc;

	public ValidData(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public String name() {
		String name;
		while (true) {
			System.out.println("📝 Please Enter Name:");
			System.out.println("⚠️ -> Your name should contain only alphabets and spaces, and be at least 20 characters long *");
			name = sc.nextLine();
			if (name.matches("^[a-zA-Z\\s]{6,20}$")) {
				return name;
			} else {
				System.out.println("❌ Invalid name. Please ensure your name contains only alphabets and spaces, and is at least 20 characters long.");
			}
		}
	}

	@Override
	public String email() {
		String email;
		while (true) {
			System.out.println("📧 Type your E-Mail:");
			System.out.println("⚠️ -> Mail should be lowercase format is .xxxx@gmail.com");
			email = sc.nextLine();
			if (email.matches("^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$")) {
				return email;
			} else {
				System.out.println("❌ Invalid email! Format is .xxxx@gmail.com");
			}
		}
	}

	@Override
	public String phone() {
		String mobile;
		while (true) {
			System.out.println("📱 Type your Mobile-Number:");
			System.out.println("⚠️ -> Number should contain 10 digits and start from 6 to 9");
			mobile = sc.nextLine();
			if (mobile.matches("^[6-9]\\d{9}$")) {
				return mobile;
			} else {
				System.out.println("❌ Invalid Number! Number should contain 10 digits and start from 6 to 9.");
			}
		}
	}

	@Override
	public String password() {
		String pass;
		while (true) {
			System.out.println("🔒 Type your Password:");
			System.out.println("⚠️ -> Password should contain (Minimum 8 to Maximum 15 Characters)...");
			pass = sc.nextLine();
			if (pass.matches("^(?=.*[0-9A-Za-z*.!@$%^&*]).{8,15}$")) {
				System.out.println("🔄 Re-enter to confirm your Password:");
				if (pass.equals(sc.nextLine())) {
					return pass;
				} else {
					System.out.println("❌ Invalid Password! Should contain '8' to '15' characters, one special character, and both cases.");
				}
			}
		}
	}

	@Override
	public String address() {
		String address;
		while (true) {
			System.out.println("🏠 Enter Address:");
			System.out.println("⚠️ -> Address should contain (Maximum 50 Characters)...");
			address = sc.nextLine();
			if (address.matches("^[a-zA-Z0-9/,-.]{10,50}$")) {
				return address;
			} else {
				System.out.println("❌ Invalid Address! Should contain a maximum of 50 characters.");
			}
		}
	}

	public String gender() {
		System.out.println("🚻 Enter Gender:");
		System.out.println("1️⃣ Male\n2️⃣ Female\n3️⃣ Other");
		switch (sc.nextLine()) {
			case "1":
				return "Male";
			case "2":
				return "Female";
			default:
				return "Other";
		}
	}
}