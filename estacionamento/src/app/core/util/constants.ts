import { environment } from './../../../environments/environment';
export class Constants {
    
    public static get API(): string {
        return environment.apiUrl;
    }
}