import { User } from "../../domain/models/User"
import { UserRequestValidate } from "../validate/UserRequestValidate"

export class UserDTO {
  public static createDomainUser(user: UserRequestValidate): User {
    return new User(user.getName(), user.getEmail(), user.getPassword(), user.getAge());
  }
}
