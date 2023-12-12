package com.company.jmixpm.screen.projecttasksbrowser;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.component.Label;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

@UiController("ProjectTasksBrowser")
@UiDescriptor("project-tasks-browser.xml")
@DialogMode(width = "800px", height = "600px", resizable = true, forceDialog = true)
public class ProjectTasksBrowser extends Screen {

    @Autowired
    private CollectionLoader<Task> tasksDl;
    @Autowired
    private Label<String> label;

    @Subscribe
    public void onInit(final InitEvent event) {
        MapScreenOptions options = (MapScreenOptions) event.getOptions();
        String param = (String) options.getParams().get("test1");
        label.setValue(param);
    }

    public ProjectTasksBrowser withProject(@Nullable Project project) {
        if (project != null) {
            tasksDl.setParameter("projectId", project.getId());
        } else {
            tasksDl.removeParameter("projectId");
        }

        tasksDl.load();

        return this;
    }
}