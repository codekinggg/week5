import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();

        System.out.print("인원수를 입력하세요: ");
        int count = scanner.nextInt();

        // 입력 받은 인원수만큼 이름과 전화번호 입력
        for (int i = 0; i < count; i++) {
            System.out.print("이름과 전화번호를 입력하세요(예: 홍길동 010-1234-5678): ");
            String name = scanner.next();
            if (name.equals("그만")) {
                break;
            }
            String phoneNumber = scanner.next();
            phonebook.addPhone(new Phone(name, phoneNumber));
        }

        // 이름 검색 및 전화번호 출력
        while (true) {
            System.out.print("검색할 이름을 입력하세요: ");
            String name = scanner.next();
            if (name.equals("그만")) {
                break;
            }
            Phone phone = phonebook.searchByName(name);
            if (phone != null) {
                System.out.println(name + "의 전화번호는 " + phone.getPhoneNumber() + "입니다.");
            } else {
                System.out.println(name + "이(가) 존재하지 않습니다.");
            }
        }

        scanner.close();
    }
}