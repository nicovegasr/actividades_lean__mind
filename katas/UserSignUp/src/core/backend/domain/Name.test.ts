import {Name} from "./Name";
/** Approach: Inside-out
 * 1.- Name is created
 * 2.- Name cannot be empty. 
*/

describe('Name test.', () => {

  test('Name is created', () => {
    const myName: Name = Name.createName("Nico");
    expect(myName).toBeInstanceOf(Name)
  });

  test('Name cannot be empty', () => {
    expect(() => Name.createName("") ).toThrow("Name cannot be empty.")
  });


})