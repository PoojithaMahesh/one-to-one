package one_to_one_uni_ass_control;

import java.util.Scanner;

import one_to_one_uni_ass_dao.Pandao;
import one_to_one_uni_ass_dao.Persondao;
import one_to_one_uni_ass_dto.PanCard;
import one_to_one_uni_ass_dto.Person;

public class PersonPan {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PanCard pancard = new PanCard();
		Person person = new Person();
		Pandao pandao = new Pandao();
		Persondao persondao = new Persondao();
		boolean flag = true;
		do {
			System.out.println("press 1 to save person and pancard");
			System.out.println("press 2 to update perso and pan card");
			System.out.println("press 3 to delete person and pancard");
			System.out.println("press 4 to get person and pancard by id");
			System.out.println("press 5 to get all the person and pancards");
			System.out.println("press 6 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter the name ");
				String name = scanner.next();
				System.out.println("enter the id");
				int id = scanner.nextInt();
				System.out.println("enter the phone");
				long phone = scanner.nextLong();
				System.out.println("enter the address");
				String address = scanner.next();
				person.setAddress(address);
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setPancard(pancard);

				System.out.println("enter the pan id");
				int pid = scanner.nextInt();
				System.out.println("enter the name");
				String pname = scanner.next();
				System.out.println("enter the address");
				String address1 = scanner.next();
				pancard.setAddress(address1);
				pancard.setName(pname);
				pancard.setId(pid);

				persondao.savePerson(person);
				System.out.println("successfully saved");

			}
				break;
			case 2: {
				boolean flag1 = true;
				do {
					System.out.println("press 1 to update person");
					System.out.println("press 2 to update pancard");
					System.out.println("press 3 to go out");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						System.out.println("enter the id");
						int id = scanner.nextInt();
						System.out.println("enter the name");
						String name = scanner.next();
						person.setId(id);
						person.setName(name);
						persondao.updatePerson(id, name);

					}
						break;
					case 2: {
						System.out.println("enter the id");
						int id = scanner.nextInt();
						System.out.println("enter the name");
						String name = scanner.next();
						pancard.setId(id);
						pancard.setName(name);
						pandao.updatePan(id, name);

					}
						break;
					case 3: {
						flag1 = false;
					}
					}
				} while (flag1);

			}
				break;
			case 3: {
				boolean flag3 = true;
				do {
					System.out.println("press1 to delete  person ");
					System.out.println("press2 to delete  pancard");
					System.out.println("press 3 to go out");
					int choice2 = scanner.nextInt();
					switch (choice2) {
					case 1: {
						System.out.println("enter the id");
						int id = scanner.nextInt();
						person.setId(id);
						persondao.deletePerson(id);
						System.out.println("deleted");

					}
						break;
					case 2: {
						System.out.println("enter the id to be deleted");
						int id = scanner.nextInt();
						pancard.setId(id);
						pandao.deletePan(id);
						System.out.println("deletd");
					}
						break;
					case 3: {
						flag3 = false;
					}
					}

				} while (flag3);

			}
				break;
			case 4: {
				boolean flag4 = true;
				do {
					System.out.println("press1 to get person by id");
					System.out.println("press 2 to get pancard by id");
					System.out.println("press 3 to go out");
					int choice3 = scanner.nextInt();
					switch (choice3) {
					case 1: {
						System.out.println("enter the id");
						int id = scanner.nextInt();
						person.setId(id);
						System.out.println(persondao.getPersonById(id));

					}
						break;
					case 2: {
						System.out.println("enter the id ");
						int id = scanner.nextInt();
						pancard.setId(id);
						System.out.println(pandao.getPanById(id));
					}
						break;
					case 3: {
						flag4 = false;
					}
					}

				} while (flag4);

			}
				break;
			case 5: {
				boolean flag5 = true;
				do {
					System.out.println("press 1 to get person table");
					System.out.println("press 2 to get pancard table");
					System.out.println("press 3 to go out");
					int choic = scanner.nextInt();
					switch (choic) {
					case 1: {
						persondao.getAllPerson();
					}
						break;
					case 2: {
						pandao.getAllPanCard();                 
					}
						break;
					case 3: {
						flag5 = false;
					}
					}
				} while (flag5);

			}
				break;

			}

		} while (flag);
	}
}
