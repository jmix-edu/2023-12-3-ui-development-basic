package com.company.jmixpm.screen.project;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.screen.projecttasksbrowser.ProjectTasksBrowser;
import io.jmix.core.common.util.ParamsMap;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
public class ProjectBrowse extends StandardLookup<Project> {
    @Autowired
    private GroupTable<Project> projectsTable;
    @Autowired
    private ScreenBuilders screenBuilders;

    @Subscribe("projectsTable.showTasks")
    public void onProjectsTableShowTasks(final Action.ActionPerformedEvent event) {
        Project selected = projectsTable.getSingleSelected();
        if (selected == null) {
            return;
        }

        screenBuilders.screen(this)
                .withScreenClass(ProjectTasksBrowser.class)
                .withOptions(new MapScreenOptions(ParamsMap.of("test1", "test2")))
                .withOpenMode(OpenMode.NEW_TAB)
                .build()
                .withProject(selected)
                .show();
    }
}