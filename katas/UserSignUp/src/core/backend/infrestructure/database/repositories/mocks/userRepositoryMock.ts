import { UserRepository } from "@core/backend/domain/interfaces/userRepository"
import { User } from "@core/backend/domain/entities/User"
import { Email } from "@core/backend/domain/entities/Email"

export class UserRepositoryMock implements UserRepository{
  save(user: User) {
    return null;
  }

  get(user: User) {
    return user;
  }
}
