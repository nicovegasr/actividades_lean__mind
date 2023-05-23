import { User } from "../models/User";

export interface UserRepository {
  save(user: User): Promise<void>;
  userExists(email: string): Promise<boolean>;
}