import { User } from "../../domain/models/User";
import { UserModel } from "../models/UserModel";

export class UserRepositoryMongoAdapter {
  async save(user: User): Promise<void> {
    const userDocument = new UserModel(user);
    await userDocument.save();
  }
  async userExists(email: string): Promise<boolean> {
    const user = await UserModel.exists({email: email});
    if (user) {
      return true;
    }
    return false
  }
}