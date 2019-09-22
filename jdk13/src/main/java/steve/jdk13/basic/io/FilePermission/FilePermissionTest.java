package steve.jdk13.basic.io.FilePermission;

import java.io.FilePermission;
import java.security.Permission;
import java.security.Permissions;

/**
 * Author  ZLH
 * Date  2019/9/22
 * Time  21:18
 * Version  1.0
 */
public class FilePermissionTest {
    public static void main(String[] args) {
        Permissions permissions = new Permissions();
        Permission readPermission = new FilePermission("./*", "read");
        Permission writePermission = new FilePermission("./*", "write");
        Permission executePermission = new FilePermission("./*", "execute");
        Permission deletePermission = new FilePermission("./*", "delete");
        Permission readlinkPermission = new FilePermission("./*", "readlink");
        permissions.add(readPermission);
        permissions.add(writePermission);
        permissions.add(executePermission);
        permissions.add(deletePermission);
        permissions.add(readlinkPermission);
        String actions = readPermission.getActions();
        System.out.println(writePermission.getActions());
    }
}
