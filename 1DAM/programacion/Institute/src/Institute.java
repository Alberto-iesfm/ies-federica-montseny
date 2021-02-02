package institute;

import java.util.Arrays;
import java.util.Objects;

public class Institute {
    private String name;
    private Group[] groups;

    public Institute(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public void instituteInfo(){
        System.out.println(name + ":");
        for (Group group:groups){
            group.groupInfo();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institute institute = (Institute) o;
        return Objects.equals(name, institute.name) && Arrays.equals(groups, institute.groups);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(groups);
        return result;
    }
}
