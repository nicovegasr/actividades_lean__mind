import {Age} from "./Age"
import {Name} from "./Name"
import {Email} from "./Email"

export class User {

  private constructor(public name: Name, public age: Age, public Email: Email) {  }
  
  public static createUser(name: string, age: number, email: string): User {
    const userEmail: Email = Email.createEmail(email) 
    const userName: Name = Name.createName(name) 
    const userAge: Age = Age.createAge(age) 
    return new User(userName, userAge, userEmail)
  }
}

