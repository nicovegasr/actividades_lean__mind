import { User } from "../entities/User";

export interface UserRepository {
  save(user: User): null,
  get(user: User): User
}