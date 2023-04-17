import { User } from "@core/backend/domain/entities/User"
import { UserRepository } from "@core/backend/domain/interfaces/userRepository"
/**
 * save user:
 * 1. If user alredy exist => thrown an error
 * 2. With correct fields => saveUser in database with repositorie. 
 * get user:
 * 1. If user doesnt exist => throw an error.
 * 2. If user exist => return user. 
 */
export class UserServices {

  public static saveUser(userRepository: UserRepository, user: User) {
    try {
      userRepository.save(user);
    } catch(Exception) {
      throw new Error(Exception as string);
    }
  }

  public static getUser(userRepository: UserRepository, user: User) {
    try {
      const userFromDatabase = userRepository.get(user);
      return userFromDatabase;
    } catch(Exception) {
      throw new Error(Exception as string)
    }
  }
}