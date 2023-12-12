package com.company.jmixpm.screen.project;

import com.company.jmixpm.entity.Project;
import io.jmix.ui.screen.*;

@UiController("Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
public class ProjectEdit extends StandardEditor<Project> {
}