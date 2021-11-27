export class User {
  name?: string;
  email?: string;
  password?: string;
  token?: string;
  autorizacao?: string
  errorMessage?: string
  selectedAccount?: number
  id?: number

  constructor(obj: User | any = {}) {
    this.name = obj.name || '';
    this.email = obj.email || '';
    this.token = obj.token || '';
    this.autorizacao = obj.autorizacao || '';
    this.errorMessage = obj.errorMessage || '';
    this.selectedAccount = obj.selectedAccount || 0;
    this.id = obj.id || 0;


  }
}
