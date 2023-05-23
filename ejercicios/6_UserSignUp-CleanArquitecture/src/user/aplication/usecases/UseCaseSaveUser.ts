import { UserRepository } from "../../domain/interfaces/UserRepository";
import { User } from "../../domain/models/User";

export const UseCaseSaveUser = async (user: User, userRepository: UserRepository) => {
  const userExists = await userRepository.userExists(user.getEmail());
  if (userExists) {
    throw new Error("User already exists.");
  }
  await userRepository.save(user);
};