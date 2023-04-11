interface AgeInterface {
  age: number
}

export class Age implements AgeInterface {
  constructor(public age: number) {  }
}